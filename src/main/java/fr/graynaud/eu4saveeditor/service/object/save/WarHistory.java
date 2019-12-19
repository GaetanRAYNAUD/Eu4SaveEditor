package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonSerialize(using = SimpleMapSerializer.class)
public class WarHistory extends SimpleMap<List<AbstractData<?>>> {

    private Map<String, List<AbstractData<?>>> events;

    public WarHistory() {
    }

    public WarHistory(String content) {
        super(content);
    }

    public Map<String, List<AbstractData<?>>> getEvents() {
        return events;
    }

    public void setEvents(Map<String, List<AbstractData<?>>> events) {
        this.events = events;
    }

    @Override
    public Map<String, List<AbstractData<?>>> getMap() {
        return events;
    }

    @Override
    public void parse(String content) {
        this.events = ParseUtils.getListObject(content, "history")
                                .stream()
                                .map(this::parseEvent)
                                .collect(Collectors.groupingBy(AbstractData::getKey));
    }

    private AbstractData<?> parseEvent(String content) {
        String[] data = content.split("=\\{", 2);

        return null;
    }
}
