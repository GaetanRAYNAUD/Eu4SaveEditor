package fr.graynaud.eu4saveeditor.service;

import fr.graynaud.eu4saveeditor.common.Constants;
import fr.graynaud.eu4saveeditor.common.FileUtils;
import fr.graynaud.eu4saveeditor.common.SaveFile;
import fr.graynaud.eu4saveeditor.common.Utils;
import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.object.DataIndex;
import fr.graynaud.eu4saveeditor.service.object.data.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class SaveServiceImpl implements SaveService {

    private static final int MAX_TRY = 100000;

    //TODO weird object with no value 'property_appraiser'

    //TODO add TagData extends StringData (default is '---') + ListTagData
    //TODO Same for all specific data ? (ex: culture, religions, goods, etc..., will be easier to do a dropdown in front)
    //TODO add ProvinceIdData extends IntData
    //TODO add ProgressData extends FloatData (Front = progress bar)
    //TODO add ListBoolData (ex: buildings)
    //TODO parent key for type to be more accurate ?

    //Fixme institutions not detected as LINE_INT
    //Fixme dynasty.dynasty not detected as LIST_STRING

    @Override
    public DataObject saveToData(MultipartFile multipartFile) throws IOException {
        AtomicInteger attempts = new AtomicInteger();
        Map<SaveFile, String> filesContent = FileUtils.unZipSave(multipartFile);
        DataObject dataObject = new DataObject();

        filesContent.forEach((saveFile, content) -> {
            attempts.set(0);
            List<AbstractData> data = new ArrayList<>();

            if (content.startsWith(Constants.STARTING_TEXT)) {
                content = content.substring(Constants.STARTING_TEXT.length());
            }

            if (saveFile == SaveFile.GAMESTATE) { //Divided because otherwise the string is too big
                int indexOfProvinces = content.indexOf("\nprovinces={");
                int indexOfCountries = content.indexOf("\ncountries={", indexOfProvinces);
                int indexOfEnd = content.indexOf("\nactive_advisors={", indexOfCountries);
                String startContent = content.substring(0, indexOfProvinces).trim();
                String provincesContent = content.substring(indexOfProvinces, indexOfCountries - 1).trim();
                String countriesContent = content.substring(indexOfCountries, indexOfEnd - 1).trim();
                String endContent = content.substring(indexOfEnd).trim();

                data.addAll(readDataOfContent(startContent, attempts, saveFile));
                data.addAll(readDataOfContent(provincesContent, attempts, saveFile));
                data.addAll(readDataOfContent(countriesContent, attempts, saveFile));
                data.addAll(readDataOfContent(endContent, attempts, saveFile));
            } else {
                content = content.trim();

                data.addAll(readDataOfContent(content, attempts, saveFile));
            }

            switch (saveFile) {
                case AI:
                    dataObject.setAi(data);
                    break;

                case META:
                    dataObject.setMeta(data);
                    break;

                case GAMESTATE:
                    dataObject.setGamestate(data);
                    break;
            }
        });

        return dataObject;
    }

    @Override
    public void dataToSave(DataObject dataObject, OutputStream outputStream) throws IOException {
        Map<SaveFile, String> map = new HashMap<>();
        map.put(SaveFile.META, dataObject.getMetaToSave());
        map.put(SaveFile.AI, dataObject.getAiToSave());
        //        map.put(SaveFile.GAMESTATE, dataObject.getGamestateToSave());

        FileUtils.zipData(outputStream, map);
    }

    private List<AbstractData> readDataOfContent(String content, AtomicInteger attempts, SaveFile saveFile) {
        int index = 0;
        List<AbstractData> data = new ArrayList<>();

        while (index < content.length() && attempts.getAndAdd(1) < MAX_TRY) {
            DataIndex dataIndex = getValue(content.substring(index), saveFile, attempts);

            data.add(dataIndex.getData());
            index += dataIndex.getIndex();
        }

        return data;
    }

    private DataIndex getValue(String content, SaveFile saveFile, AtomicInteger attempts) {
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

        int endOfLine = content.indexOf("\n");
        if (endOfLine < 0) {
            endOfLine = content.length();

            if (content.endsWith("{")) {
                index = endOfLine;
            }
        }

        String line = content.substring(index, endOfLine);

        if (line.contains("=")) {
            int separator = content.indexOf("=", index);
            String key = content.substring(index, separator).trim();
            index = separator + 1;

            DataIndex dataIndex = manageValue(saveFile.getType.apply(key), content, index, endOfLine, key, saveFile,
                                              attempts);

            dataIndex.setIndex(dataIndex.getIndex() + fixIndex);

            return dataIndex;
        }

        if (line.startsWith("map_area_data")) {
            DataIndex dataIndex = manageValue(DataType.OBJECT, content, "map_area_data".length(), endOfLine, "map_area_data", saveFile,
                                              attempts);

            dataIndex.setIndex(dataIndex.getIndex() + fixIndex);

            return dataIndex;
        }

        return new DataIndex(line.length(), null);
    }

    private DataIndex manageValue(DataType type, String content, int index, int endOfLine, String key,
                                  SaveFile saveFile, AtomicInteger attempts) {
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
                        data = new StringData(key, Utils.formatStringValue(value));
                        break;

                    case DATE:
                        LocalDate localDate = null;

                        try {
                            localDate = LocalDate.parse(value, Constants.DATE_FORMAT);
                        } catch (DateTimeParseException ignored) {}

                        data = new DateData(key, localDate);
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
            case LIST_STRING:
            case LINE_INT:
            case LINE_FLOAT:
            case LINE_STRING:
                if (content.substring(index, index + 2).equals("{\n")) {
                    index += 2;
                } else if (content.substring(index, index + 1).equals("{")) {
                    index += 1;
                }

                AtomicInteger subIndex = new AtomicInteger();
                String dataContent;

                if (index >= content.length()) {
                    dataContent = content;
                } else {
                    dataContent = content.substring(index, index + getEndOfObject(content.substring(index)));
                }

                switch (type) {
                    case OBJECT:
                        List<AbstractData> subData = new ArrayList<>();

                        while (subIndex.get() < dataContent.trim().length() && attempts.getAndAdd(1) < MAX_TRY) {
                            DataIndex dataIndex = getValue(dataContent.substring(subIndex.get()), saveFile, attempts);

                            subData.add(dataIndex.getData());

                            if (dataContent.substring(subIndex.get()).contains("{") &&
                                    dataContent.substring(subIndex.get()).stripLeading().indexOf("{") <
                                            dataContent.substring(subIndex.get()).stripLeading().indexOf("\n")) {
                                subIndex.addAndGet(skipNextObject(dataContent, subIndex.get()));
                            } else {
                                subIndex.addAndGet(dataIndex.getIndex());
                            }
                        }

                        data = new ObjectData(key, subData);
                        break;

                    case LIST_STRING:
                        subIndex.set(dataContent.length());
                        data = new ListStringData(key, Arrays.stream(dataContent.split("[\r|\n]+"))
                                                             .map(Utils::formatStringValue)
                                                             .filter(Objects::nonNull)
                                                             .collect(Collectors.toList()));
                        break;

                    case LINE_INT:
                        subIndex.set(dataContent.length());
                        data = new LineIntData(key, Arrays.stream(dataContent.trim().split(" "))
                                                          .map(Integer::valueOf)
                                                          .collect(Collectors.toList()));
                        break;

                    case LINE_FLOAT:
                        subIndex.set(dataContent.length());
                        data = new LineFloatData(key, Arrays.stream(dataContent.trim().split(" "))
                                                            .map(Double::valueOf)
                                                            .collect(Collectors.toList()));
                        break;

                    case LINE_STRING:
                        subIndex.set(dataContent.length());
                        data = new LineStringData(key, Arrays.stream(dataContent.trim().split(" "))
                                                            .map(Utils::formatStringValue)
                                                            .collect(Collectors.toList()));
                        break;
                }

                index += subIndex.get() + 2; //For end object key (\n})

                break;

            case LIST_OBJECT:
                index += 2;
                subIndex = new AtomicInteger();
                dataContent = content.substring(index, index + getEndOfObject(content.substring(index)));
                List<ObjectData> subData = new ArrayList<>();
                index += dataContent.length();

                Arrays.stream(dataContent.substring(1, dataContent.length() - 2).split("}\n.*\\{+"))
                      .filter(Predicate.not(String::isBlank))
                      .forEach(object -> {
                          int subSubIndex = 0;
                          List<AbstractData> subSubData = new ArrayList<>();

                          while (subSubIndex < object.trim().length() && attempts.getAndAdd(1) < MAX_TRY) {
                              DataIndex dataIndex = getValue(object.substring(subSubIndex), saveFile, attempts);

                              subSubData.add(dataIndex.getData());
                              if (dataIndex.getData().isValueValid()) {
                                  subSubIndex += dataIndex.getIndex();
                              }
                          }

                          subData.add(new ObjectData(key, subSubData));
                          subIndex.addAndGet(subSubIndex);
                      });

                data = new ListObjectData(key, subData);
                break;

            case UNKNOWN:
                attempts.getAndAdd(1);
                type = DataType.getType(content.substring(index, endOfLine).trim());
                DataIndex dataIndex = manageValue(type, content, content.indexOf("=") + 1,
                                                  content.contains("\n") ? content.indexOf("\n") : content.length(),
                                                  key, saveFile, attempts);

                data = dataIndex.getData();
                index = dataIndex.getIndex();

                break;
        }

        return new DataIndex(index, data);
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

    private int skipNextObject(String s, int beginIndex) {
        int opening = 0;
        int closing = 0;
        int index = 0;

        for (int i = beginIndex; i < s.length(); i++) {
            char c = s.charAt(i);
            index++;

            if (c == '{') {
                opening++;
            } else if (c == '}') {
                closing++;
            }

            if (opening != 0 && closing == opening) {
                return index;
            }
        }

        return index;
    }

}
