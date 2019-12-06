package fr.graynaud.eu4saveeditor.controller.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.Constants;
import fr.graynaud.eu4saveeditor.config.jackson.DataObjectSerializer;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.util.List;

@JsonSerialize(using = DataObjectSerializer.class)
public class DataObject {

    private List<AbstractData> gamestate;

    public DataObject(List<AbstractData> data) {
        this.gamestate = data;
    }

    @JsonIgnore
    public String getGamestateToSave() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Constants.STARTING_TEXT).append("\n");

        gamestate.forEach(data -> stringBuilder.append(data.toSave(0)));

        return stringBuilder.toString().trim();
    }

    public List<AbstractData> getGamestate() {
        return gamestate;
    }

    public void setGamestate(List<AbstractData> gamestate) {
        this.gamestate = gamestate;
    }
}
