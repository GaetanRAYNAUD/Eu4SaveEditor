package fr.graynaud.eu4saveeditor.service;

import fr.graynaud.eu4saveeditor.common.Constants;
import fr.graynaud.eu4saveeditor.common.FileUtils;
import fr.graynaud.eu4saveeditor.common.Keys;
import fr.graynaud.eu4saveeditor.common.SaveFile;
import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.object.DataIndex;
import fr.graynaud.eu4saveeditor.service.object.data.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class SaveServiceImpl implements SaveService {

    private static final int MAX_TRY = 1000;

    @Override
    public List<AbstractData> saveToData(MultipartFile multipartFile) throws IOException {
        List<AbstractData> data = new ArrayList<>();
        Map<SaveFile, String> filesContent = FileUtils.unZipSave(multipartFile);
        int index = 0;
        int tryy = 0;

        String content = filesContent.get(SaveFile.META);

        if (content.startsWith(Constants.STARTING_TEXT)) {
            content = content.substring(Constants.STARTING_TEXT.length());
        }

        content = content.trim();

        while (index < content.length() && tryy < MAX_TRY) {
            tryy++;
            DataIndex dataIndex = getValue(content.substring(index));
            data.add(dataIndex.getData());
            index += dataIndex.getIndex();
        }

        return data;
    }

    @Override
    public void dataToSave(DataObject dataObject, OutputStream outputStream) throws IOException {
        int indent = 0;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        dataObject.getData().forEach(data -> {
            stringBuilder.append(data.toSave(indent));
        });

        FileUtils.zipData(outputStream, Collections.singletonMap(SaveFile.META, stringBuilder.toString().trim()));
    }

    private DataIndex getValue(String content) {
        int index = 0;
        int fixIndex = 0;
        if (content.startsWith("}\n") || content.startsWith("{\n")) {
            content = content.substring(2);
            fixIndex += 2;
        }

        if (content.startsWith("}") || content.startsWith("\n") || content.startsWith("{")) {
            content = content.substring(1);
            fixIndex += 1;
        }

        if (content.endsWith("}\n")) {
            content = content.substring(0, content.length() - 2);
        }

        if (content.endsWith("}") || content.endsWith("\n")) {
            content = content.substring(0, content.length() - 1);
        }

        String key;

        int endOfLine = content.indexOf("\n", index);
        if (endOfLine < 0) {
            endOfLine = content.length();
        }

        String line = content.substring(index, endOfLine);

        if (line.contains("=")) {
            int separator = content.indexOf("=", index);
            key = content.substring(index, separator).trim();
            index = separator + 1;

            DataIndex dataIndex = manageValue(Keys.getType(key), content, index, endOfLine, key, line);
            dataIndex.setIndex(dataIndex.getIndex() + fixIndex);

            return dataIndex;
        }

        return new DataIndex(index + fixIndex, null);
    }

    private DataIndex manageValue(DataType type, String content, int index, int endOfLine, String key, String line) {
        AbstractData data = null;
        switch (type) {
            case STRING:
            case DATE:
            case INT:
            case FLOAT:
            case BOOL:
                String value = content.substring(index, endOfLine).trim();

                switch (type) {
                    case STRING:
                        data = new StringData(key, formatStringValue(value));
                        break;

                    case DATE:
                        data = new DateData(key, LocalDate.parse(value, Constants.DATE_FORMAT));
                        break;

                    case INT:
                        data = new IntData(key, Integer.valueOf(value));
                        break;

                    case FLOAT:
                        data = new FloatData(key, Double.valueOf(value));
                        break;

                    case BOOL:
                        data = new BoolData(key, value.equalsIgnoreCase("yes"));
                }

                index = endOfLine + 1;
                break;

            case OBJECT:
            case LIST_STRINGS:
                index += 2;
                AtomicInteger subIndex = new AtomicInteger();
                String dataContent = content.substring(index, index + getEndOfObject(content.substring(index)));

                switch (type) {
                    case OBJECT:
                        int tryy = 0;
                        List<AbstractData> subData = new ArrayList<>();

                        while (subIndex.get() < dataContent.length() && tryy < MAX_TRY) {
                            tryy++;
                            DataIndex dataIndex = getValue(dataContent.substring(subIndex.get()));
                            subData.add(dataIndex.getData());
                            subIndex.addAndGet(dataIndex.getIndex());
                        }

                        data = new ObjectData(key, subData);
                        break;

                    case LIST_STRINGS:
                        subIndex.set(dataContent.length());
                        data = new ListStringData(key, Arrays.stream(dataContent.split("[\r|\n]+"))
                                                             .map(this::formatStringValue)
                                                             .collect(Collectors.toList()));
                        break;
                }

                index += subIndex.get() + 2; //For end object key (\n})

                break;

            case LIST_OBJECTS:
                index += 2;
                subIndex = new AtomicInteger();
                dataContent = content.substring(index, index + getEndOfObject(content.substring(index)));
                List<ObjectData> subData = new ArrayList<>();
                index += dataContent.length();

                Arrays.stream(dataContent.substring(1, dataContent.length() - 2).split("}\n\\{+"))
                      .forEach(object -> {
                          int tryyy = 0;
                          int subSubIndex = 0;
                          List<AbstractData> subSubData = new ArrayList<>();

                          while (subSubIndex < object.trim().length() && tryyy < MAX_TRY) {
                              tryyy++;
                              DataIndex dataIndex = getValue(object.substring(subSubIndex));
                              subSubData.add(dataIndex.getData());
                              subSubIndex += dataIndex.getIndex();
                          }

                          subData.add(new ObjectData(key, subSubData));
                          subIndex.addAndGet(subSubIndex);
                      });

                data = new ListObjectData(key, subData);
                break;

            case UNKNOWN:
                type = DataType.getType(content.substring(index, endOfLine).trim());
                DataIndex dataIndex = manageValue(type, line, line.indexOf('=') + 1, line.length(), key, "");
                data = dataIndex.getData();
                index = dataIndex.getIndex();

                break;
        }

        return new DataIndex(index, data);
    }

    private String formatStringValue(String s) {
        s = s.trim();
        return s.substring(1, s.length() - 1);
    }

    private int getEndOfObject(String s) {
        int opening = 0;
        int closing = 0;
        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == '{') {
                opening++;
            } else if (c == '}') {
                closing++;
            }

            if (closing > opening) {
                return index;
            }

            index++;
        }

        return index;
    }

}
