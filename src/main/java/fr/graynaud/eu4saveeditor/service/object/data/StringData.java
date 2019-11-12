package fr.graynaud.eu4saveeditor.service.object.data;

import fr.graynaud.eu4saveeditor.common.Utils;

public class StringData extends AbstractData<String> {

    private Boolean hasQuotes;

    public StringData(String key, String value) {
        super(DataType.STRING, key, value);
        this.hasQuotes = Utils.hasQuotes(value);
    }

    protected StringData(DataType type, String key, String value) {
        super(type, key, value);
        this.hasQuotes = Utils.hasQuotes(this.value);
    }

    public Boolean getHasQuotes() {
        return hasQuotes;
    }

    public void setHasQuotes(Boolean hasQuotes) {
        this.hasQuotes = hasQuotes;
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + (this.hasQuotes ? "\"" : "") + this.value + (this.hasQuotes ? "\"" : "") + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null && !this.value.isEmpty();
    }
}
