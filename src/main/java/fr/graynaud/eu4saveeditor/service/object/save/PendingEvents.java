package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonSerialize(using = SimpleMapSerializer.class)
public class PendingEvents extends SimpleMap<List<PendingEvent>> {

    private Map<String, List<PendingEvent>> pendingEvents;

    public PendingEvents() {
    }

    public PendingEvents(String content) {
        super(content);
    }

    public Map<String, List<PendingEvent>> getPendingEvents() {
        return pendingEvents;
    }

    public void setPendingEvents(Map<String, List<PendingEvent>> pendingEvents) {
        this.pendingEvents = pendingEvents;
    }

    @Override
    public Map<String, List<PendingEvent>> getMap() {
        return pendingEvents;
    }

    @Override
    public void parse(String content) {
        this.pendingEvents = ParseUtils.getListObject(content, "pending_events")
                                       .stream()
                                       .map(PendingEvent::new)
                                       .collect(Collectors.groupingBy(PendingEvent::getKey, LinkedHashMap::new,
                                                                      Collectors.toList()));
    }
}
