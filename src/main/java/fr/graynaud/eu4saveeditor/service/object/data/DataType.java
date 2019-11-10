package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.regex.Pattern;

public enum DataType {
    STRING(Pattern.compile("\".*\"")),
    FLOAT(Pattern.compile("^[-+]?[0-9]+.[0-9]+$")),
    INT(Pattern.compile("^[-+]?[0-9]+$")),
    BOOL(Pattern.compile("^yes|no$")),
    OBJECT(Pattern.compile("\\{.*", Pattern.DOTALL)),
    LIST_INT(Pattern.compile("^[0-9]+ .*[0-9]+$")),
    LIST_FLOAT(Pattern.compile("^[-+]?[0-9]+.[0-9]+ .*[-+]?[0-9]+.[0-9]+$")),
    LIST_OBJECTS(Pattern.compile("\\{.*\n.*}", Pattern.DOTALL)),
    LIST_STRINGS(Pattern.compile("\".*\n.*\"")),
    DATE(Pattern.compile("^[0-9]{0,4}.[0-9]{1,2}.[0-9]{1,2}$")),
    UNKNOWN(null);

    public final Pattern pattern;

    DataType(Pattern pattern) {
        this.pattern = pattern;
    }

    public static DataType getType(String s) {
        s = s.trim();

        if (DataType.LIST_OBJECTS.pattern.matcher(s).matches()) {
            return DataType.LIST_OBJECTS;
        }

        if (DataType.OBJECT.pattern.matcher(s).matches()) {
            return DataType.OBJECT;
        }

        if (DataType.BOOL.pattern.matcher(s).matches()) {
            return DataType.BOOL;
        }

        if (DataType.INT.pattern.matcher(s).matches()) {
            return DataType.INT;
        }

        if (DataType.FLOAT.pattern.matcher(s).matches()) {
            return DataType.FLOAT;
        }

        if (DataType.DATE.pattern.matcher(s).matches()) {
            return DataType.DATE;
        }

        if (DataType.LIST_FLOAT.pattern.matcher(s).matches()) {
            return DataType.LIST_FLOAT;
        }

        if (DataType.LIST_INT.pattern.matcher(s).matches()) {
            return DataType.LIST_INT;
        }

        if (DataType.LIST_STRINGS.pattern.matcher(s).matches()) {
            return DataType.LIST_STRINGS;
        }

        if (DataType.STRING.pattern.matcher(s).matches()) {
            return DataType.STRING;
        }

        return DataType.UNKNOWN;
    }
}
