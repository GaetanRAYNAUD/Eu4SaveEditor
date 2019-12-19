package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@JsonSerialize(using = SimpleMapSerializer.class)
public class ActiveAdvisors extends SimpleMap<List<IdType>> {

    private Map<String, List<IdType>> advisors;

    public ActiveAdvisors() {
    }

    public ActiveAdvisors(String content) {
        super(content);
    }

    public Map<String, List<IdType>> getAdvisors() {
        return advisors;
    }

    public void setAdvisors(Map<String, List<IdType>> advisors) {
        this.advisors = advisors;
    }

    @Override
    public Map<String, List<IdType>> getMap() {
        return advisors;
    }

    @Override
    public void parse(String content) {
        this.advisors = ParseUtils.getListObject(content, "active_advisors")
                                  .stream()
                                  .collect(LinkedHashMap::new,
                                           (map, item) -> map.put(item.substring(0, 3), ParseUtils.getListSameObject(item, "advisor")
                                                                                                  .stream()
                                                                                                  .map(IdType::new)
                                                                                                  .collect(Collectors.toList())),
                                           Map::putAll);
    }
}
