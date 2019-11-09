package fr.graynaud.eu4saveeditor.service.object.data;

import fr.graynaud.eu4saveeditor.common.NumberUtils;

import java.util.List;

public class ListFloatData extends AbstractData<List<Double>> {

    public ListFloatData(String key, List<Double> value) {
        super(DataType.LIST_FLOAT, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t".repeat(indent)).append(this.key).append("={\n");

        stringBuilder.append("\t".repeat(indent));
        this.value.forEach(aDouble -> stringBuilder.append(NumberUtils.prettyFloat(aDouble)).append(" "));
        stringBuilder.append("\n");

        stringBuilder.append("\t".repeat(indent)).append("}\n");

        return stringBuilder.toString();
    }
}
