package fr.graynaud.eu4saveeditor.controller.object;

import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.util.List;

public class DataObject {

    private String fileName;

    private List<AbstractData> data;

    public DataObject(String fileName, List<AbstractData> data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<AbstractData> getData() {
        return data;
    }

    public void setData(List<AbstractData> data) {
        this.data = data;
    }
}
