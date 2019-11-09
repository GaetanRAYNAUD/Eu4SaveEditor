package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class ListObjectData extends AbstractData<List<AbstractData>> {

    public ListObjectData(String key, List<AbstractData> value) {
        super(DataType.LIST_OBJECTS, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");

        this.value.forEach(data -> {
            stringBuilder.append("\t".repeat(indent)).append("{\n");
            stringBuilder.append(data.toSave(indent + 1));
            stringBuilder.append("\t".repeat(indent)).append("}\n");
        });

        stringBuilder.append("\t".repeat(indent)).append("}\n");

        return stringBuilder.toString();
    }
}
