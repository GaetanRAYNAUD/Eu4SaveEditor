package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LandCombatFighter extends CombatFighter {

    private TagData rebelHomeCountry;

    private StringData rebelType;

    private DoubleData cavalry;

    private DoubleData artillery;

    private DoubleData infantry;

    private TagData participatingCountry;

    private BoolData arranged;

    private LandCombatFighterFrontLine front;

    private LandCombatFighterBackLine back;

    public LandCombatFighter() {
    }

    public LandCombatFighter(String content) {
        parse(content);
    }

    public TagData getRebelHomeCountry() {
        return rebelHomeCountry;
    }

    public void setRebelHomeCountry(TagData rebelHomeCountry) {
        this.rebelHomeCountry = rebelHomeCountry;
    }

    public StringData getRebelType() {
        return rebelType;
    }

    public void setRebelType(StringData rebelType) {
        this.rebelType = rebelType;
    }

    public DoubleData getCavalry() {
        return cavalry;
    }

    public void setCavalry(DoubleData cavalry) {
        this.cavalry = cavalry;
    }

    public DoubleData getArtillery() {
        return artillery;
    }

    public void setArtillery(DoubleData artillery) {
        this.artillery = artillery;
    }

    public DoubleData getInfantry() {
        return infantry;
    }

    public void setInfantry(DoubleData infantry) {
        this.infantry = infantry;
    }

    public TagData getParticipatingCountry() {
        return participatingCountry;
    }

    public void setParticipatingCountry(TagData participatingCountry) {
        this.participatingCountry = participatingCountry;
    }

    public BoolData getArranged() {
        return arranged;
    }

    public void setArranged(BoolData arranged) {
        this.arranged = arranged;
    }

    public LandCombatFighterFrontLine getFront() {
        return front;
    }

    public void setFront(LandCombatFighterFrontLine front) {
        this.front = front;
    }

    public LandCombatFighterBackLine getBack() {
        return back;
    }

    public void setBack(LandCombatFighterBackLine back) {
        this.back = back;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.rebelHomeCountry = ParseUtils.parseTagData(content, "rebel_home_country");
        this.rebelType = ParseUtils.parseStringData(content, "rebel_type");
        this.cavalry = ParseUtils.parseDoubleData(content, "cavalry");
        this.artillery = ParseUtils.parseDoubleData(content, "artillery");
        this.infantry = ParseUtils.parseDoubleData(content, "infantry");
        this.participatingCountry = ParseUtils.parseTagData(content, "participating_country");
        this.arranged = ParseUtils.parseBoolData(content, "arranged");
        this.front = new LandCombatFighterFrontLine(content);
        if (this.front.getMap().isEmpty()) {
            this.front = null;
        }

        this.back = new LandCombatFighterBackLine(content);
        if (this.back.getMap().isEmpty()) {
            this.back = null;
        }
    }
}
