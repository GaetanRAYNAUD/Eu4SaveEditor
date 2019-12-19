package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SiegeCombat extends PendingCombat<LandCombatFighter> {

    private DoubleData morale;

    private LongData breach;

    private LongData roll;

    private LongData total;

    private DateData lastAssault;

    private BoolData active;

    public SiegeCombat() {
        super(LandCombatFighter::new);
    }

    public SiegeCombat(String content) {
        super(LandCombatFighter::new);
        parse(content);
    }

    public DoubleData getMorale() {
        return morale;
    }

    public void setMorale(DoubleData morale) {
        this.morale = morale;
    }

    public LongData getBreach() {
        return breach;
    }

    public void setBreach(LongData breach) {
        this.breach = breach;
    }

    public LongData getRoll() {
        return roll;
    }

    public void setRoll(LongData roll) {
        this.roll = roll;
    }

    public LongData getTotal() {
        return total;
    }

    public void setTotal(LongData total) {
        this.total = total;
    }

    public DateData getLastAssault() {
        return lastAssault;
    }

    public void setLastAssault(DateData lastAssault) {
        this.lastAssault = lastAssault;
    }

    public BoolData getActive() {
        return active;
    }

    public void setActive(BoolData active) {
        this.active = active;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.morale = ParseUtils.parseDoubleData(content, "morale");
        this.breach = ParseUtils.parseLongData(content, "breach");
        this.roll = ParseUtils.parseLongData(content, "roll");
        this.total = ParseUtils.parseLongData(content, "total");
        this.lastAssault = ParseUtils.parseDateData(content, "last_assault");
        this.active = ParseUtils.parseBoolData(content, "active");
    }
}
