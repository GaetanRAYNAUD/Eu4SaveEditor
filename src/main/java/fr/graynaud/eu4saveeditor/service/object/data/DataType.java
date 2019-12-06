package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.regex.Pattern;

public enum DataType {
    STRING(Pattern.compile("\"?[a-z][A-Z]+\"?")),
    DOUBLE(Pattern.compile("^[-+]?[0-9]+\\.[0-9]+$")),
    LONG(Pattern.compile("^[-+]?[0-9]+$")),
    PROVINCE_ID(null),
    BOOL(Pattern.compile("^yes|no$")),
    OBJECT(Pattern.compile("\\{.*", Pattern.DOTALL)),
    LINE_LONG(Pattern.compile("^\\{\n*\t*[-+]?[0-9]+( [-+]?[0-9]+)*$", Pattern.DOTALL)),
    LINE_PROVINCE_ID(null),
    LINE_DOUBLE(Pattern.compile("^\\{\n*\t*[-+]?[0-9]+\\.[0-9]+( [-+]?[0-9]+\\.[0-9]+)*$", Pattern.DOTALL)),
    LINE_STRING(Pattern.compile("^\\{\n*\t*\\w+( \\w+)*$", Pattern.DOTALL)),
    LINE_TAG(Pattern.compile("^\\{\n*\t*(([A-Z0-9]{3})|([-]{3}))( (([A-Z0-9]{3})|([-]{3})))*$", Pattern.DOTALL)),
    LIST_OBJECT(Pattern.compile("^\\{.*}\n\t*\\{.*$", Pattern.DOTALL)),
    LIST_STRING(Pattern.compile("\\{\n*\t*\".*\n.*\"\n", Pattern.DOTALL)),
    LIST_TAG(Pattern.compile("\\{\n*\t*(\"?(([A-Z0-9]{3})|([-]{3}))\"?)(\n*\t*\"?(([A-Z0-9]{3})|([-]{3}))\"?)*", Pattern.DOTALL)),
    DATE(Pattern.compile("^[0-9]{4}.[0-9]{1,2}.[0-9]{1,2}$")),
    TAG(Pattern.compile("^\"?([A-Z0-9]{3})|([-]{3})\"?$")),
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

        if (DataType.DOUBLE.pattern.matcher(s).matches()) {
            return DataType.DOUBLE;
        }

        if (DataType.DATE.pattern.matcher(s).matches()) {
            return DataType.DATE;
        }

        if (DataType.LINE_DOUBLE.pattern.matcher(s).matches()) {
            return DataType.LINE_DOUBLE;
        }

        if (DataType.LINE_LONG.pattern.matcher(s).matches()) {
            return DataType.LINE_LONG;
        }

        if (DataType.LINE_TAG.pattern.matcher(s).matches()) {
            return DataType.LINE_STRING;
        }

        if (DataType.LINE_STRING.pattern.matcher(s).matches()) {
            return DataType.LINE_STRING;
        }

        if (DataType.LIST_TAG.pattern.matcher(s).matches()) {
            return DataType.LIST_STRING;
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
