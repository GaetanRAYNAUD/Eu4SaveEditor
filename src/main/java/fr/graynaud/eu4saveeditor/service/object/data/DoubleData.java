package fr.graynaud.eu4saveeditor.service.object.data;

import fr.graynaud.eu4saveeditor.common.Utils;

public class DoubleData extends AbstractData<Double> {

    public DoubleData(String key, Double value) {
        super(DataType.DOUBLE, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + Utils.prettyDouble(this.value) + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null;
    }
}
