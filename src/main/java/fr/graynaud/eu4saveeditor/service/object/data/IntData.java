package fr.graynaud.eu4saveeditor.service.object.data;

public class IntData extends AbstractData<Integer> {

    public IntData(String key, Integer value) {
        super(DataType.INT, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + this.value + "\n";
    }
}
