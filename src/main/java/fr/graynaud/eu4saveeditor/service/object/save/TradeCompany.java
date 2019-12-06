package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TradeCompany implements Parsable {

    private StringData name;

    private LineProvinceIdData provinces;

    private DoubleData power;

    private TagData owner;

    private DoubleData taxIncome;

    private BoolData strongCompany;

    private BoolData promoteInvestments;

    public TradeCompany(String content) {
        parse(content);
    }

    public StringData getName() {
        return name;
    }

    public void setName(StringData name) {
        this.name = name;
    }

    public LineProvinceIdData getProvinces() {
        return provinces;
    }

    public void setProvinces(LineProvinceIdData provinces) {
        this.provinces = provinces;
    }

    public DoubleData getPower() {
        return power;
    }

    public void setPower(DoubleData power) {
        this.power = power;
    }

    public TagData getOwner() {
        return owner;
    }

    public void setOwner(TagData owner) {
        this.owner = owner;
    }

    public DoubleData getTaxIncome() {
        return taxIncome;
    }

    public void setTaxIncome(DoubleData taxIncome) {
        this.taxIncome = taxIncome;
    }

    public BoolData getStrongCompany() {
        return strongCompany;
    }

    public void setStrongCompany(BoolData strongCompany) {
        this.strongCompany = strongCompany;
    }

    public BoolData getPromoteInvestments() {
        return promoteInvestments;
    }

    public void setPromoteInvestments(BoolData promoteInvestments) {
        this.promoteInvestments = promoteInvestments;
    }

    @Override
    public void parse(String content) {
        this.name = ParseUtils.parseStringData(content, "name");
        this.provinces = ParseUtils.parseLineProvinceIdData(content, "provinces");
        this.power = ParseUtils.parseDoubleData(content, "power");
        this.owner = ParseUtils.parseTagData(content, "owner");
        this.taxIncome = ParseUtils.parseDoubleData(content, "tax_income");
        this.strongCompany = ParseUtils.parseBoolData(content, "strong_company");
        this.promoteInvestments = ParseUtils.parseBoolData(content, "promote_investments");
    }
}
