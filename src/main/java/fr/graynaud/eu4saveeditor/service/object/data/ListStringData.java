package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class ListStringData extends AbstractData<List<String>> {

    public ListStringData(String key, List<String> value) {
        super(DataType.LIST_STRINGS, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");

        this.value.forEach(s -> stringBuilder.append("\t".repeat(indent + 1)).append("\"").append(s).append("\"\n"));

        stringBuilder.append("\t".repeat(indent)).append("}\n");

        return stringBuilder.toString();
    }
}
