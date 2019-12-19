package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RebelFaction extends Eu4Object {

    private IdType id = new IdType();

    private StringData type;

    private StringData name;

    private StringData heretic;

    private TagData country;

    private TagData independence;

    private StringData religion;

    private StringData culture;

    private StringData government;

    private ProvinceIdData province;

    private LongData seed;

    private General general = null;

    private IdType leader;

    private LineProvinceIdData possibleProvinces;

    private BoolData active;

    public RebelFaction() {
    }

    public RebelFaction(String content) {
        super(content);
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public StringData getType() {
        return type;
    }

    public void setType(StringData type) {
        this.type = type;
    }

    public StringData getName() {
        return name;
    }

    public void setName(StringData name) {
        this.name = name;
    }

    public StringData getHeretic() {
        return heretic;
    }

    public void setHeretic(StringData heretic) {
        this.heretic = heretic;
    }

    public TagData getCountry() {
        return country;
    }

    public void setCountry(TagData country) {
        this.country = country;
    }

    public TagData getIndependence() {
        return independence;
    }

    public void setIndependence(TagData independence) {
        this.independence = independence;
    }

    public StringData getReligion() {
        return religion;
    }

    public void setReligion(StringData religion) {
        this.religion = religion;
    }

    public StringData getCulture() {
        return culture;
    }

    public void setCulture(StringData culture) {
        this.culture = culture;
    }

    public StringData getGovernment() {
        return government;
    }

    public void setGovernment(StringData government) {
        this.government = government;
    }

    public ProvinceIdData getProvince() {
        return province;
    }

    public void setProvince(ProvinceIdData province) {
        this.province = province;
    }

    public LongData getSeed() {
        return seed;
    }

    public void setSeed(LongData seed) {
        this.seed = seed;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public IdType getLeader() {
        return leader;
    }

    public void setLeader(IdType leader) {
        this.leader = leader;
    }

    public LineProvinceIdData getPossibleProvinces() {
        return possibleProvinces;
    }

    public void setPossibleProvinces(LineProvinceIdData possibleProvinces) {
        this.possibleProvinces = possibleProvinces;
    }

    public BoolData getActive() {
        return active;
    }

    public void setActive(BoolData active) {
        this.active = active;
    }

    @Override
    public void parse(String content) {
        int i;

        if ((i = content.indexOf("id={")) >= 0) {
            this.id = new IdType(ParseUtils.getNextObject(content, i + 4));
        }

        this.type = ParseUtils.parseStringData(content.substring(content.indexOf("type") + 1), "type");
        this.name = ParseUtils.parseStringData(content, "name");
        this.heretic = ParseUtils.parseStringData(content, "heretic");
        this.country = ParseUtils.parseTagData(content, "country");
        this.independence = ParseUtils.parseTagData(content, "independence");
        this.religion = ParseUtils.parseStringData(content, "religion");
        this.culture = ParseUtils.parseStringData(content, "culture");
        this.government = ParseUtils.parseStringData(content, "government");
        this.province = ParseUtils.parseProvinceIdData(content, "province");
        this.seed = ParseUtils.parseLongData(content, "seed");
        this.possibleProvinces = ParseUtils.parseLineProvinceIdData(content, "possible_provinces");
        this.active = ParseUtils.parseBoolData(content, "active");

        if ((i = content.indexOf("general={")) >= 0) {
            this.general = new General(ParseUtils.getNextObject(content, i + 9));
        }

        if ((i = content.indexOf("leader={")) >= 0) {
            this.leader = new IdType(ParseUtils.getNextObject(content, i + 8));
        }
    }
}
