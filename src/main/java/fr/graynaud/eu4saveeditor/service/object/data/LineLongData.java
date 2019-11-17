package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;
import java.util.Objects;

public class LineLongData extends AbstractData<List<Long>> {

    public LineLongData(String key, List<Long> value) {
        super(DataType.LINE_LONG, key, value);
    }

    protected LineLongData(DataType dataType, String key, List<Long> value) {
        super(dataType, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");

        stringBuilder.append("\t".repeat(indent));
        this.value.forEach(integer -> stringBuilder.append(integer).append(" "));
        stringBuilder.append("\n");

        stringBuilder.append("\t".repeat(indent)).append("}\n");

        return stringBuilder.toString();
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null && !this.value.isEmpty() && this.value.stream().anyMatch(Objects::nonNull);
    }
}
