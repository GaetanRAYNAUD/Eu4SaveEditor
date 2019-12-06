package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@JsonSerialize(using = SimpleMapSerializer.class)
public class IdeaDates extends SimpleMap<DateData> implements Parsable {

    private Map<String, DateData> ideaDates;

    public IdeaDates() {
    }

    public IdeaDates(String content) {
        parse(content);
    }

    public Map<String, DateData> getFlags() {
        return ideaDates;
    }

    public void setFlags(Map<String, DateData> flags) {
        this.ideaDates = flags;
    }

    @Override
    public Map<String, DateData> getMap() {
        return ideaDates;
    }

    @Override
    public void parse(String content) {
        this.ideaDates = ParseUtils.getCleanListString(content, "idea_dates")
                               .stream()
                               .map(s -> ParseUtils.parseDateData(s, s.split("=")[0].trim()))
                               .collect(Collectors.toMap(AbstractData::getKey, Function.identity()));
    }
}
