package fr.graynaud.eu4saveeditor.service.object.data;

import java.util.List;

public class ListIntData extends AbstractData<List<Integer>> {

    public ListIntData(String key, List<Integer> value) {
        super(DataType.LIST_INT, key, value);
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
}
