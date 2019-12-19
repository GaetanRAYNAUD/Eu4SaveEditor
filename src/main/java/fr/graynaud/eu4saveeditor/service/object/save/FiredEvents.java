package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class FiredEvents extends Eu4Object {

    private List<StringData> stringEvents;

    private List<IdType> idTypeEvents;

    public FiredEvents() {
    }

    public FiredEvents(String content) {
        super(content);
    }

    public List<StringData> getStringEvents() {
        return stringEvents;
    }

    public void setStringEvents(List<StringData> stringEvents) {
        this.stringEvents = stringEvents;
    }

    public List<IdType> getIdTypeEvents() {
        return idTypeEvents;
    }

    public void setIdTypeEvents(List<IdType> idTypeEvents) {
        this.idTypeEvents = idTypeEvents;
    }

    @Override
    public void parse(String content) {
        content = ParseUtils.getNextObject(content, content.indexOf("\nfired_events={") + 1);
        List<String> events = ParseUtils.getListSameObject(content, "\n\tid=");

        idTypeEvents = new ArrayList<>();
        stringEvents = new ArrayList<>();
        events.forEach(s -> {
            if (s.contains("id={")) {
                idTypeEvents.add(new IdType(s.substring(s.indexOf("id={") + 1)));
            } else {
                stringEvents.add(ParseUtils.parseStringData(s, "id"));
            }
        });
    }
}
