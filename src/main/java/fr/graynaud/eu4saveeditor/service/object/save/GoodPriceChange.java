package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GoodPriceChange extends Eu4Object {

    private StringData key;

    private DoubleData value;

    private DateData expiryDate;

    public GoodPriceChange() {
    }

    public GoodPriceChange(String content) {
        parse(content);
    }

    public StringData getKey() {
        return key;
    }

    public void setKey(StringData key) {
        this.key = key;
    }

    public DoubleData getValue() {
        return value;
    }

    public void setValue(DoubleData value) {
        this.value = value;
    }

    public DateData getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(DateData expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public void parse(String content) {
        this.key = ParseUtils.parseStringData(content, "key");
        this.value = ParseUtils.parseDoubleData(content, "value");
        this.expiryDate = ParseUtils.parseDateData(content, "expiry_date");
    }
}
