package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LineTagData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ActiveWar extends War {

    private LineTagData attackers;

    private LineTagData defenders;

    public ActiveWar() {
    }

    public ActiveWar(String content) {
        parse(content);
    }

    public LineTagData getAttackers() {
        return attackers;
    }

    public void setAttackers(LineTagData attackers) {
        this.attackers = attackers;
    }

    public LineTagData getDefenders() {
        return defenders;
    }

    public void setDefenders(LineTagData defenders) {
        this.defenders = defenders;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.attackers = ParseUtils.parseLineTagData(content, "attackers");
        this.defenders = ParseUtils.parseLineTagData(content, "defenders");
    }
}
