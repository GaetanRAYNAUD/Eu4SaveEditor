package fr.graynaud.eu4saveeditor.service.object.data;

public abstract class AbstractData<T> {

    private final DataType type;

    protected String key;

    protected T value;

    public AbstractData(DataType type, String key, T value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public DataType getType() {
        return type;
    }

    public T getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public abstract String toSave(Integer indent);
}
