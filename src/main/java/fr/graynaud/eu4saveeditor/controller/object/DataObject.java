package fr.graynaud.eu4saveeditor.controller.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import fr.graynaud.eu4saveeditor.common.Constants;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataObject {

    private String fileName;

    private Map<String, AbstractData> meta;

    private Map<String, AbstractData> gamestate;

    private Map<String, AbstractData> ai;

    public String getFileName() {
        return fileName;
    }

    public DataObject setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public Map<String, AbstractData> getMeta() {
        return meta;
    }

    @JsonIgnore
    public String getMetaToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        meta.forEach((key, data) -> {
            stringBuilder.append(data.toSave(0));
        });

        return stringBuilder.toString().trim();
    }

    @JsonIgnore
    public void setMeta(List<AbstractData> meta) {
        if (meta != null && !meta.isEmpty()) {
            this.meta = meta.stream().collect(Collectors.toMap(AbstractData::getKey, a -> a, (u, v) -> {
                throw new IllegalStateException(String.format("Duplicate key %s", u));
            }, LinkedHashMap::new));
        }
    }

    @JsonSetter("meta")
    public void setMeta(Map<String, AbstractData> meta) {
        this.meta = meta;
    }

    public Map<String, AbstractData> getGamestate() {
        return gamestate;
    }

    @JsonIgnore
    public String getGamestateToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        gamestate.forEach((key, data) -> {
            stringBuilder.append(data.toSave(0));
        });

        return stringBuilder.toString().trim();
    }

    @JsonIgnore
    public void setGamestate(List<AbstractData> gamestate) {
        if (gamestate != null && !gamestate.isEmpty()) {
            this.gamestate = gamestate.stream().collect(Collectors.toMap(AbstractData::getKey, a -> a, (u, v) -> {
                throw new IllegalStateException(String.format("Duplicate key %s", u));
            }, LinkedHashMap::new));
        }
    }

    @JsonSetter("gamestate")
    public void setGamestate(Map<String, AbstractData> gamestate) {
        this.gamestate = gamestate;
    }

    public Map<String, AbstractData> getAi() {
        return ai;
    }

    @JsonIgnore
    public String getAiToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        ai.forEach((key, data) -> {
            stringBuilder.append(data.toSave(0));
        });

        return stringBuilder.toString().trim();
    }

    @JsonIgnore
    public void setAi(List<AbstractData> ai) {
        if (ai != null && !ai.isEmpty()) {
            this.ai = ai.stream().collect(Collectors.toMap(AbstractData::getKey, a -> a, (u, v) -> {
                throw new IllegalStateException(String.format("Duplicate key %s", u));
            }, LinkedHashMap::new));
        }
    }

    @JsonSetter("ai")
    public void setAi(Map<String, AbstractData> ai) {
        this.ai = ai;
    }
}
