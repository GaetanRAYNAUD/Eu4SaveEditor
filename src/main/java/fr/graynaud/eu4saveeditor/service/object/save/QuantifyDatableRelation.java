package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class QuantifyDatableRelation extends DatableRelation {

    private DoubleData amount;

    public QuantifyDatableRelation() {
    }

    public QuantifyDatableRelation(String content) {
        parse(content);
    }

    public DoubleData getAmount() {
        return amount;
    }

    public void setAmount(DoubleData amount) {
        this.amount = amount;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.amount = ParseUtils.parseDoubleData(content, "amount");
    }
}
