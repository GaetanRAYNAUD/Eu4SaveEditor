package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class ObjectData extends AbstractData<List<AbstractData>> {

    public ObjectData(String key, List<AbstractData> value) {
        super(DataType.OBJECT, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return toSave(indent, true);
    }

    public String toSave(Integer indent, boolean printKey) {
        StringBuilder stringBuilder = new StringBuilder();

        if (printKey) {
            stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");
        }

        this.value.forEach(data -> stringBuilder.append(data.toSave(indent + 1)));

        if (printKey) {
            stringBuilder.append("\t".repeat(indent)).append("}\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null && !this.value.isEmpty() && this.value.stream().anyMatch(AbstractData::isValueValid);
    }
}
