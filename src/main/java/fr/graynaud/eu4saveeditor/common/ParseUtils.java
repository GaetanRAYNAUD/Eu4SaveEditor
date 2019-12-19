package fr.graynaud.eu4saveeditor.common;

import fr.graynaud.eu4saveeditor.service.object.data.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class ParseUtils {

    private ParseUtils() {
    }

    public static StringData parseStringData(String content, String key) {
        return parseStringData(content, key, StringData::new);
    }

    public static TagData parseTagData(String content, String key) {
        return parseStringData(content, key, TagData::new);
    }

    public static LongData parseLongData(String content, String key) {
        return parseLongData(content, key, LongData::new);
    }

    public static ProvinceIdData parseProvinceIdData(String content, String key) {
        return parseLongData(content, key, ProvinceIdData::new);
    }

    public static DoubleData parseDoubleData(String content, String key) {
        return parseDoubleData(content, key, DoubleData::new);
    }

    public static BoolData parseBoolData(String content, String key) {
        if (content.contains(key)) {
            return new BoolData(key.trim(), getCleanString(content, key).equals("yes"));
        }

        return null;
    }

    public static ListStringData parseListStringData(String content, String key) {
        return parseListStringData(content, key, ListStringData::new);
    }

    public static ListTagData parseListTagData(String content, String key) {
        return parseListStringData(content, key, ListTagData::new);
    }

    public static LineStringData parseLineStringData(String content, String key) {
        return parseLineStringData(content, key, LineStringData::new);
    }

    public static LineTagData parseLineTagData(String content, String key) {
        return parseLineStringData(content, key, LineTagData::new);
    }

    public static LineLongData parseLineLongData(String content, String key) {
        return parseLineLongData(content, key, LineLongData::new);
    }

    public static LineProvinceIdData parseLineProvinceIdData(String content, String key) {
        return parseLineLongData(content, key, LineProvinceIdData::new);
    }

    public static LineDoubleData parseLineDoubleData(String content, String key) {
        return parseLineDoubleData(content, key, LineDoubleData::new);
    }

    public static DateData parseDateData(String content, String key) {
        int keyIndex = content.indexOf(key + "=");

        if (keyIndex >= 0) {
            LocalDate localDate = null;
            keyIndex += key.length() + 1;
            int endIndex = content.indexOf("\n", keyIndex);

            if (endIndex < 0) {
                endIndex = content.length();
            }

            try {
                localDate = Utils.nullSafeParseLocalDate(
                        formatStringValue(content.substring(keyIndex, endIndex).trim()));
            } catch (DateTimeParseException ignored) {
            }

            return new DateData(key.trim(), localDate);
        }

        return null;
    }

    public static boolean hasQuotes(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        return s.startsWith("\"") && s.endsWith("\"");
    }

    public static int getEndOfObject(String s, int beginIndex) {
        int opening = 0;
        int closing = 0;
        int index = 0;
        char c;

        for (int i = beginIndex; i < s.length(); i++) {
            c = s.charAt(i);

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

    public static int skipNextObject(String s, int beginIndex) {
        int opening = 0;
        int closing = 0;
        int index = 0;
        char c;

        for (int i = beginIndex; i < s.length(); i++) {
            c = s.charAt(i);
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

    public static List<String> getListSameString(String content, String key) {
        List<String> value = null;

        if (content.contains(key + "=")) {
            value = Arrays.stream(content.trim().split(key))
                          .skip(1)
                          .map(ParseUtils::formatStringValue)
                          .filter(Objects::nonNull)
                          .map(s -> {
                              int index = s.indexOf("\n");
                              if (index >= 0) {
                                  s = s.substring(0, index);
                              }

                              return s.replace("=", "");
                          })
                          .map(ParseUtils::formatStringValue)
                          .filter(Objects::nonNull)
                          .collect(Collectors.toList());
        }

        return value;
    }

    public static List<String> getCleanListString(String content, String key) {
        int keyIndex = content.indexOf(key + "={");
        List<String> value = new ArrayList<>();

        if (keyIndex >= 0) {
            keyIndex += key.length() + 2;
            int endIndex = content.indexOf("}", keyIndex);

            if (endIndex < 0) {
                endIndex = content.length();
            }

            value = Arrays.stream(content.substring(keyIndex, endIndex).trim().split("[\r|\n]+"))
                          .map(ParseUtils::formatStringValue)
                          .filter(Objects::nonNull)
                          .collect(Collectors.toList());
        }

        return value;
    }

    public static List<String> getListObject(String content, String key) {
        int keyIndex = content.indexOf(key + "={");
        List<String> value = new ArrayList<>();

        if (keyIndex >= 0) {
            keyIndex += key.length() + 2;
            int endIndex = keyIndex + getEndOfObject(content, keyIndex);

            if (endIndex < 0) {
                endIndex = content.length();
            }

            String copy = content.substring(keyIndex, endIndex).trim();
            value = new ArrayList<>();
            int index = 0;

            while (index < copy.length()) {
                String nextObject = getNextObject(copy, index);
                value.add(nextObject.trim());
                index += nextObject.length();
            }
        }

        return value;
    }

    public static List<String> getListSameObject(String content, String key) {
        List<String> value = new ArrayList<>();

        if (content.contains(key)) {
            value = Arrays.stream(content.split(Pattern.quote(key)))
                          .skip(1)
                          .map(s -> key + s)
                          .map(s -> getNextObject(s, 0))
                          .collect(Collectors.toList());
        }

        return value;
    }

    public static String getNextObject(String content, int beginIndex) {
        return content.substring(beginIndex, beginIndex + skipNextObject(content, beginIndex));
    }

    public static String formatStringValue(String s) {
        s = s.trim();

        if (s.isEmpty() || s.isBlank()) {
            return null;
        }

        if (hasQuotes(s)) {
            return s.substring(1, s.length() - 1);
        } else {
            return s;
        }
    }

    private static <T extends StringData> T parseStringData(String content, String key, BiFunction<String, String, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), getCleanString(content, key));
        }

        return null;
    }

    private static <T extends LongData> T parseLongData(String content, String key, BiFunction<String, Long, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), Utils.nullSafeParseLong(getCleanString(content, key)));
        }

        return null;
    }

    private static <T extends DoubleData> T parseDoubleData(String content, String key, BiFunction<String, Double, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), Utils.nullSafeParseDouble(getCleanString(content, key)));
        }

        return null;
    }

    private static <T extends ListStringData> T parseListStringData(String content, String key, BiFunction<String, List<String>, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), getCleanListString(content, key));
        }

        return null;
    }

    private static <T extends LineStringData> T parseLineStringData(String content, String key, BiFunction<String, List<String>, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), getCleanLineString(content, key));
        }

        return null;
    }

    private static <T extends LineLongData> T parseLineLongData(String content, String key, BiFunction<String, List<Long>, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), getCleanLineString(content, key).stream()
                                                                              .map(Utils::nullSafeParseLong)
                                                                              .collect(Collectors.toList()));
        }

        return null;
    }

    private static <T extends LineDoubleData> T parseLineDoubleData(String content, String key, BiFunction<String, List<Double>, T> function) {
        if (content.contains(key)) {
            return function.apply(key.trim(), getCleanLineString(content, key).stream()
                                                                              .map(Utils::nullSafeParseDouble)
                                                                              .collect(Collectors.toList()));
        }

        return null;
    }

    private static List<String> getCleanLineString(String content, String key) {
        int keyIndex = content.indexOf(key + "={");
        List<String> value = null;

        if (keyIndex >= 0) {
            keyIndex += key.length() + 2;
            int endIndex = content.indexOf("}", keyIndex);

            if (endIndex < 0) {
                endIndex = content.length();
            }

            value = Arrays.stream(content.substring(keyIndex, endIndex).trim().split("\\s+"))
                          .map(ParseUtils::formatStringValue)
                          .filter(Objects::nonNull)
                          .collect(Collectors.toList());

        }

        return value;
    }

    private static String getCleanString(String content, String key) {
        int keyIndex = content.indexOf(key + "=");
        String value = null;

        if (keyIndex >= 0) {
            keyIndex += key.length() + 1;
            int endIndex = content.indexOf("\n", keyIndex);

            if (endIndex < 0) {
                endIndex = content.length();
            }

            value = formatStringValue(content.substring(keyIndex, endIndex));
        }

        return value;
    }
}
