package fr.graynaud.eu4saveeditor.service.object.data;

public class LongData extends AbstractData<Long> {

    public LongData(String key, Long value) {
        super(DataType.LONG, key, value);
    }

    protected LongData(DataType dataType, String key, Long value) {
        super(dataType, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + this.value + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null;
    }
}
