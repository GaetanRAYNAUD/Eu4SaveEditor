package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class ListObjectData extends AbstractData<List<ObjectData>> {

    public ListObjectData(String key, List<ObjectData> value) {
        super(DataType.LIST_OBJECT, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");

        this.value.forEach(data -> {
            stringBuilder.append("\t".repeat(indent)).append("{\n");
            stringBuilder.append(data.toSave(indent + 1, false));
            stringBuilder.append("\t".repeat(indent + 1)).append("}\n");
        });

        stringBuilder.append("\t".repeat(indent)).append("}\n");

        return stringBuilder.toString();
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null && !this.value.isEmpty() && this.value.stream().anyMatch(AbstractData::isValueValid);
    }
}
