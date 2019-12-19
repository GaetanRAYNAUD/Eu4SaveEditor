package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;

import java.util.*;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TechLevelDates extends Eu4Object {

    private Map<Integer, DateData> adm;

    private Map<Integer, DateData> dip;

    private Map<Integer, DateData> mil;

    public TechLevelDates() {
    }

    public TechLevelDates(String content) {
        super(content);
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
        this.adm = Collections.singletonMap(Integer.valueOf(admLevel.replace("\"", "")), ParseUtils.parseDateData(datas.get(0), admLevel));
        this.dip = Collections.singletonMap(Integer.valueOf(dipLevel.replace("\"", "")), ParseUtils.parseDateData(datas.get(1), dipLevel));
        this.mil = Collections.singletonMap(Integer.valueOf(milLevel.replace("\"", "")), ParseUtils.parseDateData(datas.get(2), milLevel));
    }
}
