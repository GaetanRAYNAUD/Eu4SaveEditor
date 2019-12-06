package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.LineTagData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TechLevelDates implements Parsable {

    private Map<Integer, DateData> adm = new HashMap<>();

    private Map<Integer, DateData> dip = new HashMap<>();

    private Map<Integer, DateData> mil = new HashMap<>();

    public TechLevelDates() {
    }

    public TechLevelDates(String content) {
        this.parse(content);
    }

    public Map<Integer, DateData> getAdm() {
        return adm;
    }

    public void setAdm(Map<Integer, DateData> adm) {
        this.adm = adm;
    }

    public Map<Integer, DateData> getDip() {
        return dip;
    }

    public void setDip(Map<Integer, DateData> dip) {
        this.dip = dip;
    }

    public Map<Integer, DateData> getMil() {
        return mil;
    }

    public void setMil(Map<Integer, DateData> mil) {
        this.mil = mil;
    }

    @Override
    public void parse(String content) {
        content = ParseUtils.getNextObject(content, content.indexOf("\n" + "tech_level_dates={") + 1);
        List<String> datas = Arrays.stream(content.split("\n")).skip(1).limit(3).map(String::trim).collect(Collectors.toList());
        String admLevel = datas.get(0).split("=")[0];
        String dipLevel = datas.get(1).split("=")[0];
        String milLevel = datas.get(2).split("=")[0];
        this.adm.put(Integer.valueOf(admLevel.replace("\"", "")), ParseUtils.parseDateData(datas.get(0), admLevel));
        this.dip.put(Integer.valueOf(dipLevel.replace("\"", "")), ParseUtils.parseDateData(datas.get(1), dipLevel));
        this.mil.put(Integer.valueOf(milLevel.replace("\"", "")), ParseUtils.parseDateData(datas.get(2), milLevel));
    }
}
