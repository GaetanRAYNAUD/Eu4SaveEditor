package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class ListTagData extends ListStringData {

    public ListTagData(String key, List<String> value) {
        super(DataType.LIST_TAG, key, value);
    }
}
