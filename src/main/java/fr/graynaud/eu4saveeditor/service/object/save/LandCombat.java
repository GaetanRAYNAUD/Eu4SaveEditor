package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LandCombat extends PendingCombat<LandCombatFighter> {

    private BoolData message;

    public LandCombat() {
        super(LandCombatFighter::new);
    }

    public LandCombat(String content) {
        super(LandCombatFighter::new);
        parse(content);
    }

    public BoolData getMessage() {
        return message;
    }

    public void setMessage(BoolData message) {
        this.message = message;
    }
    @Override
    public void parse(String content) {
        super.parse(content);
        this.message = ParseUtils.parseBoolData(content, "message");
    }
}
