package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Hre extends Empire {

    private LongData continent;

    private BoolData imperialBanAllowed;

    private BoolData internalHreCb;

    private BoolData hreInheritable;

    private BoolData allowsFemaleEmperor;

    private LineTagData electors;

    public Hre() {
    }

    public Hre(String content) {
        parse(content);
    }

    public LongData getContinent() {
        return continent;
    }

    public void setContinent(LongData continent) {
        this.continent = continent;
    }

    public BoolData getImperialBanAllowed() {
        return imperialBanAllowed;
    }

    public void setImperialBanAllowed(BoolData imperialBanAllowed) {
        this.imperialBanAllowed = imperialBanAllowed;
    }

    public BoolData getInternalHreCb() {
        return internalHreCb;
    }

    public void setInternalHreCb(BoolData internalHreCb) {
        this.internalHreCb = internalHreCb;
    }

    public BoolData getHreInheritable() {
        return hreInheritable;
    }

    public void setHreInheritable(BoolData hreInheritable) {
        this.hreInheritable = hreInheritable;
    }

    public BoolData getAllowsFemaleEmperor() {
        return allowsFemaleEmperor;
    }

    public void setAllowsFemaleEmperor(BoolData allowsFemaleEmperor) {
        this.allowsFemaleEmperor = allowsFemaleEmperor;
    }

    public LineTagData getElectors() {
        return electors;
    }

    public void setElectors(LineTagData electors) {
        this.electors = electors;
    }

    @Override
    public void parse(String content) {
        int i = content.indexOf("\nempire={");
        content = ParseUtils.getNextObject(content, i + 1);
        super.parse(content);
        this.continent = ParseUtils.parseLongData(content, "continent");
        this.imperialBanAllowed = ParseUtils.parseBoolData(content, "imperial_ban_allowed");
        this.internalHreCb = ParseUtils.parseBoolData(content, "internal_hre_cb");
        this.hreInheritable = ParseUtils.parseBoolData(content, "hre_inheritable");
        this.allowsFemaleEmperor = ParseUtils.parseBoolData(content, "allows_female_emperor");
        this.electors = ParseUtils.parseLineTagData(content, "electors");
    }
}
