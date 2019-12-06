package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class TradeCompanyManager implements Parsable {

    private List<TradeCompany> tradeCompanies;

    public TradeCompanyManager() {
    }

    public TradeCompanyManager(String content) {
        parse(content);
    }

    public List<TradeCompany> getTradeCompanies() {
        return tradeCompanies;
    }

    public void setTradeCompanies(List<TradeCompany> tradeCompanies) {
        this.tradeCompanies = tradeCompanies;
    }

    @Override
    public void parse(String content) {
        this.tradeCompanies = ParseUtils.getListSameObject(content, "trade_company={")
                                        .stream()
                                        .map(TradeCompany::new)
                                        .collect(Collectors.toList());
    }
}
