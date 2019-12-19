package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.SimpleMapSerializer;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@JsonSerialize(using = SimpleMapSerializer.class)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LedgerStatistics extends SimpleMap<Map<Long, Long>> {

    private Map<String, Map<Long, Long>> ledgerData;

    public LedgerStatistics() {
    }

    public LedgerStatistics(String content) {
        super(content);
    }

    public Map<String, Map<Long, Long>> getLedgerData() {
        return ledgerData;
    }

    public void setLedgerData(Map<String, Map<Long, Long>> ledgerData) {
        this.ledgerData = ledgerData;
    }

    @Override
    public Map<String, Map<Long, Long>> getMap() {
        return ledgerData;
    }

    @Override
    public void parse(String content) {
        this.ledgerData = ParseUtils.getListSameObject(content, "ledger_data")
                                    .stream()
                                    .collect(LinkedHashMap::new,
                                             (map, item) -> map.put(ParseUtils.parseTagData(item, "name").getValue(), parseData(item)),
                                             Map::putAll);
        this.ledgerData.values().removeIf(Objects::isNull);
    }

    private Map<Long, Long> parseData(String content) {
        int index = content.indexOf("\tdata={");

        if (index >= 0) {
            content = ParseUtils.getNextObject(content, index);
            content = content.substring(7, content.length() - 1);
            return Arrays.stream(content.split(" "))
                         .skip(1)
                         .map(String::trim)
                         .filter(Predicate.not(String::isBlank))
                         .collect(LinkedHashMap::new,
                                  (map, item) -> map.put(Long.valueOf(item.split("=")[0]), Long.valueOf(item.split("=")[1])),
                                  Map::putAll);
        }

        return null;
    }
}
