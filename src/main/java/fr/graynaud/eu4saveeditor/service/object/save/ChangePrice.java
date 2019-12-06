package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ChangePrice implements Parsable {

    private GoodPrice noGoods;

    private GoodPrice grain;

    private GoodPrice wine;

    private GoodPrice wool;

    private GoodPrice cloth;

    private GoodPrice fish;

    private GoodPrice fur;

    private GoodPrice salt;

    private GoodPrice navalSupplies;

    private GoodPrice copper;

    private GoodPrice gold;

    private GoodPrice iron;

    private GoodPrice slaves;

    private GoodPrice ivory;

    private GoodPrice tea;

    private GoodPrice chinaware;

    private GoodPrice spices;

    private GoodPrice coffee;

    private GoodPrice cotton;

    private GoodPrice sugar;

    private GoodPrice tobacco;

    private GoodPrice cocoa;

    private GoodPrice silk;

    private GoodPrice dyes;

    private GoodPrice tropicalWood;

    private GoodPrice livestock;

    private GoodPrice incense;

    private GoodPrice glass;

    private GoodPrice paper;

    private GoodPrice gems;

    private GoodPrice coal;

    private GoodPrice unknown;

    public ChangePrice() {
    }

    public ChangePrice(String content) {
        parse(content);
    }

    public GoodPrice getNoGoods() {
        return noGoods;
    }

    public void setNoGoods(GoodPrice noGoods) {
        this.noGoods = noGoods;
    }

    public GoodPrice getGrain() {
        return grain;
    }

    public void setGrain(GoodPrice grain) {
        this.grain = grain;
    }

    public GoodPrice getWine() {
        return wine;
    }

    public void setWine(GoodPrice wine) {
        this.wine = wine;
    }

    public GoodPrice getWool() {
        return wool;
    }

    public void setWool(GoodPrice wool) {
        this.wool = wool;
    }

    public GoodPrice getCloth() {
        return cloth;
    }

    public void setCloth(GoodPrice cloth) {
        this.cloth = cloth;
    }

    public GoodPrice getFish() {
        return fish;
    }

    public void setFish(GoodPrice fish) {
        this.fish = fish;
    }

    public GoodPrice getFur() {
        return fur;
    }

    public void setFur(GoodPrice fur) {
        this.fur = fur;
    }

    public GoodPrice getSalt() {
        return salt;
    }

    public void setSalt(GoodPrice salt) {
        this.salt = salt;
    }

    public GoodPrice getNavalSupplies() {
        return navalSupplies;
    }

    public void setNavalSupplies(GoodPrice navalSupplies) {
        this.navalSupplies = navalSupplies;
    }

    public GoodPrice getCopper() {
        return copper;
    }

    public void setCopper(GoodPrice copper) {
        this.copper = copper;
    }

    public GoodPrice getGold() {
        return gold;
    }

    public void setGold(GoodPrice gold) {
        this.gold = gold;
    }

    public GoodPrice getIron() {
        return iron;
    }

    public void setIron(GoodPrice iron) {
        this.iron = iron;
    }

    public GoodPrice getSlaves() {
        return slaves;
    }

    public void setSlaves(GoodPrice slaves) {
        this.slaves = slaves;
    }

    public GoodPrice getIvory() {
        return ivory;
    }

    public void setIvory(GoodPrice ivory) {
        this.ivory = ivory;
    }

    public GoodPrice getTea() {
        return tea;
    }

    public void setTea(GoodPrice tea) {
        this.tea = tea;
    }

    public GoodPrice getChinaware() {
        return chinaware;
    }

    public void setChinaware(GoodPrice chinaware) {
        this.chinaware = chinaware;
    }

    public GoodPrice getSpices() {
        return spices;
    }

    public void setSpices(GoodPrice spices) {
        this.spices = spices;
    }

    public GoodPrice getCoffee() {
        return coffee;
    }

    public void setCoffee(GoodPrice coffee) {
        this.coffee = coffee;
    }

    public GoodPrice getCotton() {
        return cotton;
    }

    public void setCotton(GoodPrice cotton) {
        this.cotton = cotton;
    }

    public GoodPrice getSugar() {
        return sugar;
    }

    public void setSugar(GoodPrice sugar) {
        this.sugar = sugar;
    }

    public GoodPrice getTobacco() {
        return tobacco;
    }

    public void setTobacco(GoodPrice tobacco) {
        this.tobacco = tobacco;
    }

    public GoodPrice getCocoa() {
        return cocoa;
    }

    public void setCocoa(GoodPrice cocoa) {
        this.cocoa = cocoa;
    }

    public GoodPrice getSilk() {
        return silk;
    }

    public void setSilk(GoodPrice silk) {
        this.silk = silk;
    }

    public GoodPrice getDyes() {
        return dyes;
    }

    public void setDyes(GoodPrice dyes) {
        this.dyes = dyes;
    }

    public GoodPrice getTropicalWood() {
        return tropicalWood;
    }

    public void setTropicalWood(GoodPrice tropicalWood) {
        this.tropicalWood = tropicalWood;
    }

    public GoodPrice getLivestock() {
        return livestock;
    }

    public void setLivestock(GoodPrice livestock) {
        this.livestock = livestock;
    }

    public GoodPrice getIncense() {
        return incense;
    }

    public void setIncense(GoodPrice incense) {
        this.incense = incense;
    }

    public GoodPrice getGlass() {
        return glass;
    }

    public void setGlass(GoodPrice glass) {
        this.glass = glass;
    }

    public GoodPrice getPaper() {
        return paper;
    }

    public void setPaper(GoodPrice paper) {
        this.paper = paper;
    }

    public GoodPrice getGems() {
        return gems;
    }

    public void setGems(GoodPrice gems) {
        this.gems = gems;
    }

    public GoodPrice getCoal() {
        return coal;
    }

    public void setCoal(GoodPrice coal) {
        this.coal = coal;
    }

    public GoodPrice getUnknown() {
        return unknown;
    }

    public void setUnknown(GoodPrice unknown) {
        this.unknown = unknown;
    }

    @Override
    public void parse(String content) {
        String subContent = ParseUtils.getNextObject(content, content.indexOf("change_price={"));
        this.noGoods = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("nogoods={")));
        this.grain = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("grain={")));
        this.wine = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("wine={")));
        this.wool = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("wool={")));
        this.cloth = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("cloth={")));
        this.fish = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("fish={")));
        this.fur = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("fur={")));
        this.salt = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("salt={")));
        this.navalSupplies = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("naval_supplies={")));
        this.copper = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("copper={")));
        this.gold = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("gold={")));
        this.iron = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("iron={")));
        this.slaves = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("slaves={")));
        this.ivory = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("ivory={")));
        this.tea = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("tea={")));
        this.chinaware = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("chinaware={")));
        this.spices = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("spices={")));
        this.coffee = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("coffee={")));
        this.cotton = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("cotton={")));
        this.sugar = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("sugar={")));
        this.tobacco = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("tobacco={")));
        this.cocoa = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("cocoa={")));
        this.silk = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("silk={")));
        this.dyes = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("dyes={")));
        this.tropicalWood = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("tropical_wood={")));
        this.livestock = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("livestock={")));
        this.incense = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("incense={")));
        this.glass = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("glass={")));
        this.paper = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("paper={")));
        this.gems = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("gems={")));
        this.coal = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("coal={")));
        this.unknown = new GoodPrice(ParseUtils.getNextObject(subContent, subContent.indexOf("unknown={")));
    }
}
