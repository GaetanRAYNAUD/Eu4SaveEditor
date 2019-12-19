package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CombatFighter extends Eu4Object {

    private LongData dice;

    private BoolData isAttacker;

    private IdType unit;

    private DoubleData losses;

    private LineDoubleData lossesType;

    private TagData participatingCountry;

    public CombatFighter() {
    }

    public CombatFighter(String content) {
        parse(content);
    }

    public LongData getDice() {
        return dice;
    }

    public void setDice(LongData dice) {
        this.dice = dice;
    }

    public BoolData getIsAttacker() {
        return isAttacker;
    }

    public void setIsAttacker(BoolData isAttacker) {
        this.isAttacker = isAttacker;
    }

    public IdType getUnit() {
        return unit;
    }

    public void setUnit(IdType unit) {
        this.unit = unit;
    }

    public DoubleData getLosses() {
        return losses;
    }

    public void setLosses(DoubleData losses) {
        this.losses = losses;
    }

    public LineDoubleData getLossesType() {
        return lossesType;
    }

    public void setLossesType(LineDoubleData lossesType) {
        this.lossesType = lossesType;
    }

    public TagData getParticipatingCountry() {
        return participatingCountry;
    }

    public void setParticipatingCountry(TagData participatingCountry) {
        this.participatingCountry = participatingCountry;
    }

    @Override
    public void parse(String content) {
        this.dice = ParseUtils.parseLongData(content, "dice");
        this.isAttacker = ParseUtils.parseBoolData(content, "dice");
        this.losses = ParseUtils.parseDoubleData(content, "losses");
        this.lossesType = ParseUtils.parseLineDoubleData(content, "lossesType");
        this.participatingCountry = ParseUtils.parseTagData(content, "participatingCountry");

        int i;
        if ((i = content.indexOf("unit={")) >= 0) {
            this.unit = new IdType(ParseUtils.getNextObject(content, i + 9));
        }
    }
}
