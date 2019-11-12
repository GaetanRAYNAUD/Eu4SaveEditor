package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.regex.Pattern;

public enum DataType {
    STRING(Pattern.compile("\".*\"")),
    FLOAT(Pattern.compile("^[-+]?[0-9]+\\.[0-9]+$")),
    INT(Pattern.compile("^[-+]?[0-9]+$")),
    BOOL(Pattern.compile("^yes|no$")),
    OBJECT(Pattern.compile("\\{.*", Pattern.DOTALL)),
    LINE_INT(Pattern.compile("^[-+]?[0-9]+( [-+]?[0-9]+)*$")),
    LINE_FLOAT(Pattern.compile("^[-+]?[0-9]+\\.[0-9]+( [-+]?[0-9]+\\.[0-9]+)*$")),
    LINE_STRING(Pattern.compile("^\\w+( \\w+)*$")),
    LIST_OBJECT(Pattern.compile("\\{.*\n.*}", Pattern.DOTALL)),
    LIST_STRING(Pattern.compile("\".*\n.*\"")),
    DATE(Pattern.compile("^[0-9]{0,4}.[0-9]{1,2}.[0-9]{1,2}$")),
    TAG(Pattern.compile("^\"?[A-Z]{3}\"?$")),
    UNKNOWN(null);

    public final Pattern pattern;

    DataType(Pattern pattern) {
        this.pattern = pattern;
    }

    public static DataType getType(String s) {
        s = s.trim();

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

        if (DataType.TAG.pattern.matcher(s).matches()) {
            return DataType.TAG;
        }

        if (DataType.LINE_FLOAT.pattern.matcher(s).matches()) {
            return DataType.LINE_FLOAT;
        }

        if (DataType.LINE_INT.pattern.matcher(s).matches()) {
            return DataType.LINE_INT;
        }

        if (DataType.LINE_STRING.pattern.matcher(s).matches()) {
            return DataType.LINE_STRING;
        }

        if (DataType.LIST_STRING.pattern.matcher(s).matches()) {
            return DataType.LIST_STRING;
        }

        if (DataType.LIST_OBJECT.pattern.matcher(s).matches()) {
            return DataType.LIST_OBJECT;
        }

        if (DataType.OBJECT.pattern.matcher(s).matches()) {
            return DataType.OBJECT;
        }

        if (DataType.STRING.pattern.matcher(s).matches()) {
            return DataType.STRING;
        }

        return DataType.UNKNOWN;
    }
}
