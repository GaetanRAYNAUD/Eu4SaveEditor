package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Religion extends Eu4Object {

    private LongData amountOfProvinces;

    private DateData enable;

    private BoolData hreReligion;

    private BoolData originalHreReligion;

    private BoolData hreHereticReligion;

    private BoolData originalHreHereticReligion;

    private List<TagData> league;

    private Papacy papacy;

    public Religion() {
    }

    public Religion(String content) {
        this.parse(content);
    }

    public LongData getAmountOfProvinces() {
        return amountOfProvinces;
    }

    public void setAmountOfProvinces(LongData amountOfProvinces) {
        this.amountOfProvinces = amountOfProvinces;
    }

    public DateData getEnable() {
        return enable;
    }

    public void setEnable(DateData enable) {
        this.enable = enable;
    }

    public BoolData getHreReligion() {
        return hreReligion;
    }

    public void setHreReligion(BoolData hreReligion) {
        this.hreReligion = hreReligion;
    }

    public BoolData getOriginalHreReligion() {
        return originalHreReligion;
    }

    public void setOriginalHreReligion(BoolData originalHreReligion) {
        this.originalHreReligion = originalHreReligion;
    }

    public BoolData getHreHereticReligion() {
        return hreHereticReligion;
    }

    public void setHreHereticReligion(BoolData hreHereticReligion) {
        this.hreHereticReligion = hreHereticReligion;
    }

    public BoolData getOriginalHreHereticReligion() {
        return originalHreHereticReligion;
    }

    public void setOriginalHreHereticReligion(BoolData originalHreHereticReligion) {
        this.originalHreHereticReligion = originalHreHereticReligion;
    }

    public List<TagData> getLeague() {
        return league;
    }

    public void setLeague(List<TagData> league) {
        this.league = league;
    }

    public Papacy getPapacy() {
        return papacy;
    }

    public void setPapacy(Papacy papacy) {
        this.papacy = papacy;
    }

    @Override
    public void parse(String content) {
        this.amountOfProvinces = ParseUtils.parseLongData(content, "amount_of_provinces");
        this.enable = ParseUtils.parseDateData(content, "enable");
        this.hreReligion = ParseUtils.parseBoolData(content, "hre_religion");
        this.originalHreReligion = ParseUtils.parseBoolData(content, "original_hre_religion");
        this.hreHereticReligion = ParseUtils.parseBoolData(content, "hre_heretic_religion");
        this.originalHreHereticReligion = ParseUtils.parseBoolData(content, "original_hre_heretic_religion");

        List<String> leagues = ParseUtils.getListSameString(content, "league");

        if (leagues != null) {
            this.league = leagues.stream().map(s -> ParseUtils.parseTagData("league=" + s, "league")).collect(Collectors.toList());
        }

        if (content.contains("papacy")) {
            this.papacy = new Papacy(content);
        }
    }
}
