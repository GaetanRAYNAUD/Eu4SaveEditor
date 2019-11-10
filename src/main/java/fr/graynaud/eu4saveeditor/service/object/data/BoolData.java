package fr.graynaud.eu4saveeditor.service.object.data;

public class BoolData extends AbstractData<Boolean> {

    public BoolData(String key, Boolean value) {
        super(DataType.BOOL, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + (this.value ? "yes" : "no") + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null;
    }
}
