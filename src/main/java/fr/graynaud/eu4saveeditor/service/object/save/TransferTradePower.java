package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class TransferTradePower extends QuantifyDatableRelation {

    private BoolData isEnforced;

    public TransferTradePower() {
    }

    public TransferTradePower(String content) {
        parse(content);
    }

    public BoolData getIsEnforced() {
        return isEnforced;
    }

    public void setIsEnforced(BoolData isEnforced) {
        this.isEnforced = isEnforced;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.isEnforced = ParseUtils.parseBoolData(content, "is_enforced");
    }
}
