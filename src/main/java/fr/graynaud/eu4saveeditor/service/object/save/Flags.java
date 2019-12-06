package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@JsonSerialize(using = SimpleMapSerializer.class)
public class Flags extends SimpleMap<DateData> implements Parsable {

    private Map<String, DateData> flags;

    public Flags() {
    }

    public Flags(String content) {
        parse(content);
    }

    public Map<String, DateData> getFlags() {
        return flags;
    }

    public void setFlags(Map<String, DateData> flags) {
        this.flags = flags;
    }

    @Override
    public Map<String, DateData> getMap() {
        return flags;
    }

    @Override
    public void parse(String content) {
        this.flags = ParseUtils.getCleanListString(content, "flags")
                               .stream()
                               .map(s -> ParseUtils.parseDateData(s, s.split("=")[0].trim()))
                               .collect(Collectors.toMap(AbstractData::getKey, Function.identity()));
    }
}
