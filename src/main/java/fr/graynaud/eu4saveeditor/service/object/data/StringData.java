package fr.graynaud.eu4saveeditor.service.object.data;

public class StringData extends AbstractData<String> {

    public StringData(String key, String value) {
        super(DataType.STRING, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + '"' + this.key + "=" + this.value + "\"\n";
    }
}
