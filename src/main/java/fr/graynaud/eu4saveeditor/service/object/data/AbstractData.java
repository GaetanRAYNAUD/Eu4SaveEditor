package fr.graynaud.eu4saveeditor.service.object.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = BoolData.class, name = "BOOL"),
               @JsonSubTypes.Type(value = DateData.class, name = "DATE"),
               @JsonSubTypes.Type(value = FloatData.class, name = "FLOAT"),
               @JsonSubTypes.Type(value = LongData.class, name = "LONG"),
               @JsonSubTypes.Type(value = LineFloatData.class, name = "LINE_FLOAT"),
               @JsonSubTypes.Type(value = LineLongData.class, name = "LINE_LONG"),
               @JsonSubTypes.Type(value = LineStringData.class, name = "LINE_STRING"),
               @JsonSubTypes.Type(value = LineTagData.class, name = "LINE_TAG"),
               @JsonSubTypes.Type(value = LineProvinceIdData.class, name = "LINE_PROVINCE_ID"),
               @JsonSubTypes.Type(value = ListObjectData.class, name = "LIST_OBJECT"),
               @JsonSubTypes.Type(value = ListStringData.class, name = "LIST_STRING"),
               @JsonSubTypes.Type(value = ListTagData.class, name = "LIST_TAG"),
               @JsonSubTypes.Type(value = ObjectData.class, name = "OBJECT"),
               @JsonSubTypes.Type(value = TagData.class, name = "TAG"),
               @JsonSubTypes.Type(value = ProvinceIdData.class, name = "PROVINCE_ID"),
               @JsonSubTypes.Type(value = NotParsedData.class, name = "NOT_PARSED"),
               @JsonSubTypes.Type(value = StringData.class, name = "STRING")})
public abstract class AbstractData<T> {

    private Long id = UUID.randomUUID().getLeastSignificantBits();

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

    public String getKey() {
        return key;
    }

    public void setId(Long id) {
        this.id = id;
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
