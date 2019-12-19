package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonSerialize(using = SimpleMapSerializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class LandCombatFighterLine extends SimpleMap<IdType> {

    private Map<String, IdType> line;

    public LandCombatFighterLine() {
    }

    public Map<String, IdType> getLine() {
        return line;
    }

    public void setLine(Map<String, IdType> line) {
        this.line = line;
    }

    @Override
    public Map<String, IdType> getMap() {
        return line;
    }

    public void parse(String content, String key) {
        this.line = ParseUtils.getListObject(content, key)
                              .stream()
                              .collect(LinkedHashMap::new,
                                       (map, item) -> map.put(item.substring(0, item.indexOf("=")), new IdType(item.substring(item.indexOf("={")))),
                                       Map::putAll);
    }
}
