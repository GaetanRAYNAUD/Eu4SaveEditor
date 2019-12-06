package fr.graynaud.eu4saveeditor.service.object.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.config.jackson.AbstractDataSerializer;

@JsonSerialize(using = AbstractDataSerializer.class)
public abstract class AbstractData<T> {

    private DataType type;

    protected String key;

    protected T value;

    public AbstractData() {
    }

    protected AbstractData(DataType type, String key, T value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @JsonIgnore
    public String getKey() {
        return key;
    }

    @JsonIgnore
    public DataType getType() {
        return type;
    }

    public void setType(DataType type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract String toSave(Integer indent);

    @JsonIgnore
    public abstract Boolean isValueValid();

    @Override
    public String toString() {
        return toSave(0);
    }
}
