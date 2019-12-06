package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.ListStringData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CultureGroup implements Parsable {

    private ListStringData germanic;

    private ListStringData british;

    private ListStringData french;

    private ListStringData westSlavic;

    private ListStringData carpathian;

    private ListStringData baltic;

    private ListStringData maghrebi;

    private ListStringData iranian;

    private ListStringData altaic;

    private ListStringData malay;

    private ListStringData southEastAsianGroup;

    private ListStringData westernAryan;

    private ListStringData southernAfrican;

    private ListStringData greatLakesGroup;

    private ListStringData african;

    private ListStringData cushitic;

    private ListStringData evenks;

    public CultureGroup() {
    }

    public CultureGroup(String content) {
        parse(content);
    }

    public ListStringData getGermanic() {
        return germanic;
    }

    public void setGermanic(ListStringData germanic) {
        this.germanic = germanic;
    }

    public ListStringData getBritish() {
        return british;
    }

    public void setBritish(ListStringData british) {
        this.british = british;
    }

    public ListStringData getFrench() {
        return french;
    }

    public void setFrench(ListStringData french) {
        this.french = french;
    }

    public ListStringData getWestSlavic() {
        return westSlavic;
    }

    public void setWestSlavic(ListStringData westSlavic) {
        this.westSlavic = westSlavic;
    }

    public ListStringData getCarpathian() {
        return carpathian;
    }

    public void setCarpathian(ListStringData carpathian) {
        this.carpathian = carpathian;
    }

    public ListStringData getBaltic() {
        return baltic;
    }

    public void setBaltic(ListStringData baltic) {
        this.baltic = baltic;
    }

    public ListStringData getMaghrebi() {
        return maghrebi;
    }

    public void setMaghrebi(ListStringData maghrebi) {
        this.maghrebi = maghrebi;
    }

    public ListStringData getIranian() {
        return iranian;
    }

    public void setIranian(ListStringData iranian) {
        this.iranian = iranian;
    }

    public ListStringData getAltaic() {
        return altaic;
    }

    public void setAltaic(ListStringData altaic) {
        this.altaic = altaic;
    }

    public ListStringData getMalay() {
        return malay;
    }

    public void setMalay(ListStringData malay) {
        this.malay = malay;
    }

    public ListStringData getSouthEastAsianGroup() {
        return southEastAsianGroup;
    }

    public void setSouthEastAsianGroup(ListStringData southEastAsianGroup) {
        this.southEastAsianGroup = southEastAsianGroup;
    }

    public ListStringData getWesternAryan() {
        return westernAryan;
    }

    public void setWesternAryan(ListStringData westernAryan) {
        this.westernAryan = westernAryan;
    }

    public ListStringData getSouthernAfrican() {
        return southernAfrican;
    }

    public void setSouthernAfrican(ListStringData southernAfrican) {
        this.southernAfrican = southernAfrican;
    }

    public ListStringData getGreatLakesGroup() {
        return greatLakesGroup;
    }

    public void setGreatLakesGroup(ListStringData greatLakesGroup) {
        this.greatLakesGroup = greatLakesGroup;
    }

    public ListStringData getAfrican() {
        return african;
    }

    public void setAfrican(ListStringData african) {
        this.african = african;
    }

    public ListStringData getCushitic() {
        return cushitic;
    }

    public void setCushitic(ListStringData cushitic) {
        this.cushitic = cushitic;
    }

    public ListStringData getEvenks() {
        return evenks;
    }

    public void setEvenks(ListStringData evenks) {
        this.evenks = evenks;
    }

    @Override
    public void parse(String content) {
        this.germanic = ParseUtils.parseListStringData(content, "\"germanic\"");
        this.british = ParseUtils.parseListStringData(content, "\"british\"");
        this.french = ParseUtils.parseListStringData(content, "\"french\"");
        this.westSlavic = ParseUtils.parseListStringData(content, "\"west_slavic\"");
        this.carpathian = ParseUtils.parseListStringData(content, "\"carpathian\"");
        this.baltic = ParseUtils.parseListStringData(content, "\"baltic\"");
        this.maghrebi = ParseUtils.parseListStringData(content, "\"maghrebi\"");
        this.iranian = ParseUtils.parseListStringData(content, "\"iranian\"");
        this.altaic = ParseUtils.parseListStringData(content, "\"altaic\"");
        this.malay = ParseUtils.parseListStringData(content, "\"malay\"");
        this.southEastAsianGroup = ParseUtils.parseListStringData(content, "\"southeastasian_group\"");
        this.westernAryan = ParseUtils.parseListStringData(content, "\"western_aryan\"");
        this.southernAfrican = ParseUtils.parseListStringData(content, "\"southern_african\"");
        this.greatLakesGroup = ParseUtils.parseListStringData(content, "\"great_lakes_group\"");
        this.african = ParseUtils.parseListStringData(content, "\"african\"");
        this.cushitic = ParseUtils.parseListStringData(content, "\"cushitic\"");
        this.evenks = ParseUtils.parseListStringData(content, "\"evenks\"");
    }
}
