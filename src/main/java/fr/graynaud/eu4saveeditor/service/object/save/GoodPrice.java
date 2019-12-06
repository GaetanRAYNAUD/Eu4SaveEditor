package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GoodPrice implements Parsable {

    private DoubleData currentPrice;

    private List<GoodPriceChange> changePrice;

    public GoodPrice() {
    }

    public GoodPrice(String content) {
        parse(content);
    }

    public DoubleData getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(DoubleData currentPrice) {
        this.currentPrice = currentPrice;
    }

    public List<GoodPriceChange> getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(List<GoodPriceChange> changePrice) {
        this.changePrice = changePrice;
    }

    @Override
    public void parse(String content) {
        this.currentPrice = ParseUtils.parseDoubleData(content, "current_price");
        List<String> changePrices = ParseUtils.getListSameObject(content, "change_price");
        if (changePrices != null) {
            this.changePrice = changePrices.stream()
                                           .filter(Objects::nonNull)
                                           .map(GoodPriceChange::new)
                                           .collect(Collectors.toList());
        }
    }
}
