package fr.graynaud.eu4saveeditor.service.object;

import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

public class DataIndex {

    private int index;

    private AbstractData data;

    public DataIndex(int index, AbstractData data) {
        this.index = index;
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public AbstractData getData() {
        return data;
    }

    public void setData(AbstractData data) {
        this.data = data;
    }
}
