package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.ProvinceIdData;

import java.util.function.Supplier;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class PendingCombat<F extends CombatFighter> extends Eu4Object {

    private IdType id;

    private ProvinceIdData location;

    private LongData phase;

    private LongData day;

    private LongData duration;

    private F attacker;

    private F defender;

    public PendingCombat(Supplier<F> supplier) {
        this.attacker = supplier.get();
        this.defender = supplier.get();
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public ProvinceIdData getLocation() {
        return location;
    }

    public void setLocation(ProvinceIdData location) {
        this.location = location;
    }

    public LongData getPhase() {
        return phase;
    }

    public void setPhase(LongData phase) {
        this.phase = phase;
    }

    public LongData getDay() {
        return day;
    }

    public void setDay(LongData day) {
        this.day = day;
    }

    public LongData getDuration() {
        return duration;
    }

    public void setDuration(LongData duration) {
        this.duration = duration;
    }

    public F getAttacker() {
        return attacker;
    }

    public void setAttacker(F attacker) {
        this.attacker = attacker;
    }

    public F getDefender() {
        return defender;
    }

    public void setDefender(F defender) {
        this.defender = defender;
    }

    @Override
    public void parse(String content) {
        this.id = new IdType(ParseUtils.getNextObject(content, content.indexOf("id={") + 4));
        this.location = ParseUtils.parseProvinceIdData(content, "location");
        this.phase = ParseUtils.parseProvinceIdData(content, "phase");
        this.day = ParseUtils.parseProvinceIdData(content, "day");
        this.duration = ParseUtils.parseProvinceIdData(content, "duration");
        this.attacker.parse(ParseUtils.getNextObject(content, content.indexOf("attacker={")));
        this.defender.parse(ParseUtils.getNextObject(content, content.indexOf("defender={")));
    }
}
