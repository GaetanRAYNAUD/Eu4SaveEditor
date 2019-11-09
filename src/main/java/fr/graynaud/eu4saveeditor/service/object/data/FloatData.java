package fr.graynaud.eu4saveeditor.service.object.data;

public class FloatData extends AbstractData<Double> {

    public FloatData(String key, Double value) {
        super(DataType.FLOAT, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + this.value + "\n";
    }
}
