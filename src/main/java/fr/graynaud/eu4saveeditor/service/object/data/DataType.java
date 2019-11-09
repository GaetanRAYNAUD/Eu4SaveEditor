package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.regex.Pattern;

public enum DataType {
    STRING(Pattern.compile("\".*\"")),
    FLOAT(Pattern.compile("^[-+]?[0-9]+.[0-9]+$")),
    INT(Pattern.compile("^[-+]?[0-9]+$")),
    BOOL(Pattern.compile("^yes|no$")),
    OBJECT(Pattern.compile("\\{")),
    LIST_INT(Pattern.compile("^[0-9]+ .*[0-9]+$")),
    LIST_FLOAT(Pattern.compile("^[-+]?[0-9]+.[0-9]+ .*[-+]?[0-9]+.[0-9]+$")),
    LIST_OBJECTS(Pattern.compile("\\{.*\n.*}", Pattern.DOTALL)),
    LIST_STRINGS(Pattern.compile("\".*\n.*\"")),
    LIST_KEY_VALUE(null),
    DATE(Pattern.compile("^[0-9]{0,4}.[0-9]{1,2}.[0-9]{1,2}$")),
    UNKNOWN(null);

    public final Pattern pattern;

    DataType(Pattern pattern) {
        this.pattern = pattern;
    }

    public static DataType getType(String s) {
        s = s.trim();

        if (s.matches(DataType.LIST_OBJECTS.pattern.pattern())) {
            return DataType.LIST_OBJECTS;
        }

        if (s.matches(DataType.OBJECT.pattern.pattern())) {
            return DataType.OBJECT;
        }

        if (s.matches(DataType.BOOL.pattern.pattern())) {
            return DataType.BOOL;
        }

        if (s.matches(DataType.FLOAT.pattern.pattern())) {
            return DataType.FLOAT;
        }

        if (s.matches(DataType.DATE.pattern.pattern())) {
            return DataType.DATE;
        }

        if (s.matches(DataType.INT.pattern.pattern())) {
            return DataType.INT;
        }

        if (s.matches(DataType.LIST_FLOAT.pattern.pattern())) {
            return DataType.LIST_FLOAT;
        }

        if (s.matches(DataType.LIST_INT.pattern.pattern())) {
            return DataType.LIST_INT;
        }

        if (s.matches(DataType.LIST_STRINGS.pattern.pattern())) {
            return DataType.LIST_STRINGS;
        }

        if (s.matches(DataType.STRING.pattern.pattern())) {
            return DataType.STRING;
        }

        return DataType.UNKNOWN;
    }
}
