package fr.graynaud.eu4saveeditor.controller.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.Constants;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.util.List;

@JsonSerialize(using = DataObjectSerializer.class)
public class DataObject {

    private String fileName;

    private List<AbstractData> meta;

    private List<AbstractData> gamestate;

    private List<AbstractData> ai;

    public String getFileName() {
        return fileName;
    }

    public DataObject setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public List<AbstractData> getMeta() {
        return meta;
    }

    @JsonIgnore
    public String getMetaToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        meta.forEach(data -> stringBuilder.append(data.toSave(0)));

        return stringBuilder.toString().trim();
    }

    @JsonIgnore
    public String getGamestateToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        gamestate.forEach(data -> stringBuilder.append(data.toSave(0)));

        return stringBuilder.toString().trim();
    }

    @JsonIgnore
    public String getAiToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        ai.forEach(data -> stringBuilder.append(data.toSave(0)));

        return stringBuilder.toString().trim();
    }

    public void setMeta(List<AbstractData> meta) {
        this.meta = meta;
    }

    public List<AbstractData> getGamestate() {
        return gamestate;
    }

    public void setGamestate(List<AbstractData> gamestate) {
        this.gamestate = gamestate;
    }

    public List<AbstractData> getAi() {
        return ai;
    }

    public void setAi(List<AbstractData> ai) {
        this.ai = ai;
    }
}
