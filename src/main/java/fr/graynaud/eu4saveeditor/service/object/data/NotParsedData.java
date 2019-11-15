package fr.graynaud.eu4saveeditor.service.object.data;

import fr.graynaud.eu4saveeditor.common.Utils;

public class NotParsedData extends AbstractData<String> {

    public NotParsedData(String key, String value) {
        super(DataType.NOT_PARSED, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.value + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return true;
    }
}
