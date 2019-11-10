package fr.graynaud.eu4saveeditor.service.object.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = BoolData.class, name = "BOOL"),
               @JsonSubTypes.Type(value = DateData.class, name = "DATE"),
               @JsonSubTypes.Type(value = FloatData.class, name = "FLOAT"),
               @JsonSubTypes.Type(value = IntData.class, name = "INT"),
               @JsonSubTypes.Type(value = ListFloatData.class, name = "LIST_FLOAT"),
               @JsonSubTypes.Type(value = ListIntData.class, name = "LIST_INT"),
               @JsonSubTypes.Type(value = ListObjectData.class, name = "LIST_OBJECTS"),
               @JsonSubTypes.Type(value = ListStringData.class, name = "LIST_STRINGS"),
               @JsonSubTypes.Type(value = ObjectData.class, name = "OBJECT"),
               @JsonSubTypes.Type(value = StringData.class, name = "STRING")})
public abstract class AbstractData<T> {

    private DataType type;

    protected String key;

    protected T value;

    public AbstractData() {
    }

    public AbstractData(DataType type, String key, T value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public String getKey() {
        return key;
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
