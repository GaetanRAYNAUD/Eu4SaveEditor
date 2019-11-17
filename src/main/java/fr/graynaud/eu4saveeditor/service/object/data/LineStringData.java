package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;
import java.util.Objects;

public class LineStringData extends AbstractData<List<String>> {

    public LineStringData(String key, List<String> value) {
        super(DataType.LINE_STRING, key, value);
    }

    protected LineStringData(DataType dataType, String key, List<String> value) {
        super(dataType, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");

        stringBuilder.append("\t".repeat(indent));
        this.value.forEach(s -> stringBuilder.append(s).append(" "));
        stringBuilder.append("\n");

        stringBuilder.append("\t".repeat(indent)).append("}\n");

        return stringBuilder.toString();
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null && !this.value.isEmpty() && this.value.stream().anyMatch(Objects::nonNull);
    }
}
