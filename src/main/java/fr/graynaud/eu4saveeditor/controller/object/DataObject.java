package fr.graynaud.eu4saveeditor.controller.object;

import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.util.List;

public class DataObject {

    private List<AbstractData> data;

    public DataObject(List<AbstractData> data) {
        this.data = data;
    }

    public List<AbstractData> getData() {
        return data;
    }

    public void setData(List<AbstractData> data) {
        this.data = data;
    }
}
