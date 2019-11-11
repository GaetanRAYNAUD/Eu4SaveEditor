package fr.graynaud.eu4saveeditor.service.object.data;

import fr.graynaud.eu4saveeditor.common.Utils;

public class FloatData extends AbstractData<Double> {

    public FloatData(String key, Double value) {
        super(DataType.FLOAT, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + Utils.prettyFloat(this.value) + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null;
    }
}
