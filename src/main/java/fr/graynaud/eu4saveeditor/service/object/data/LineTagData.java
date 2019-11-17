package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class LineTagData extends LineStringData {

    public LineTagData(String key, List<String> value) {
        super(DataType.LINE_TAG, key, value);
    }
}
