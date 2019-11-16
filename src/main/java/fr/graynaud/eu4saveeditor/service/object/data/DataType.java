package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.regex.Pattern;

public enum DataType {
    STRING(Pattern.compile("\"?[a-z][A-Z]+\"?")),
    FLOAT(Pattern.compile("^[-+]?[0-9]+\\.[0-9]+$")),
    LONG(Pattern.compile("^[-+]?[0-9]+$")),
    BOOL(Pattern.compile("^yes|no$")),
    OBJECT(Pattern.compile("\\{.*", Pattern.DOTALL)),
    LINE_INT(Pattern.compile("^\\{\n*\t*[-+]?[0-9]+( [-+]?[0-9]+)*$", Pattern.DOTALL)),
    LINE_FLOAT(Pattern.compile("^\\{\n*\t*[-+]?[0-9]+\\.[0-9]+( [-+]?[0-9]+\\.[0-9]+)*$", Pattern.DOTALL)),
    LINE_STRING(Pattern.compile("^\\{\n*\t*\\w+( \\w+)*$", Pattern.DOTALL)),
    LIST_OBJECT(Pattern.compile("^\\{.*}\n\t*\\{.*$", Pattern.DOTALL)),
    LIST_STRING(Pattern.compile("\\{\n*\t*\".*\n.*\"\n", Pattern.DOTALL)),
    DATE(Pattern.compile("^[0-9]{4}.[0-9]{1,2}.[0-9]{1,2}$")),
    TAG(Pattern.compile("^\"?[A-Z]{3}\"?$")),
    UNKNOWN(null),
    NOT_PARSED(null);

    public final Pattern pattern;

    DataType(Pattern pattern) {
        this.pattern = pattern;
    }

    public static DataType getType(String s) {
        s = s.trim();

        if (DataType.LONG.pattern.matcher(s).matches()) {
            return DataType.LONG;
        }

        if (DataType.FLOAT.pattern.matcher(s).matches()) {
            return DataType.FLOAT;
        }

        if (DataType.DATE.pattern.matcher(s).matches()) {
            return DataType.DATE;
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

        if (DataType.BOOL.pattern.matcher(s).matches()) {
            return DataType.BOOL;
        }

        if (DataType.TAG.pattern.matcher(s).matches()) {
            return DataType.TAG;
        }

        return DataType.STRING;
    }
}
