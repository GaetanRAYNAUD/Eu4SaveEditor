package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LandCombatFighterFrontLine extends LandCombatFighterLine {

    public LandCombatFighterFrontLine() {
    }

    public LandCombatFighterFrontLine(String content) {
        parse(content);
    }

    @Override
    public void parse(String content) {
        super.parse(content, "front");
    }
}
