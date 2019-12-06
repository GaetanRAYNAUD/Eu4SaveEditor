package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LineTagData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TradeLeague implements Parsable {

    private LongData id;

    private LineTagData members;

    public TradeLeague() {
    }

    public TradeLeague(String content) {
        parse(content);
    }

    public LongData getId() {
        return id;
    }

    public void setId(LongData id) {
        this.id = id;
    }

    public LineTagData getMembers() {
        return members;
    }

    public void setMembers(LineTagData members) {
        this.members = members;
    }

    @Override
    public void parse(String content) {
        this.id = ParseUtils.parseLongData(content, "id");
        this.members = ParseUtils.parseLineTagData(content, "members");
    }
}
