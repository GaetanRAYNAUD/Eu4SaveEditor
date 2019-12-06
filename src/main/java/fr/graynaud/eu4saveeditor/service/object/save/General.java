package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class General implements Parsable {

    private StringData name;

    private StringData dynasty;

    private StringData type;

    private LongData manuever;

    private LongData fire;

    private LongData shock;

    private TagData country;

    private DateData activation;

    private IdType id;

    public General() {
    }

    public General(String content) {
        parse(content);
    }

    public StringData getName() {
        return name;
    }

    public void setName(StringData name) {
        this.name = name;
    }

    public StringData getDynasty() {
        return dynasty;
    }

    public void setDynasty(StringData dynasty) {
        this.dynasty = dynasty;
    }

    public StringData getType() {
        return type;
    }

    public void setType(StringData type) {
        this.type = type;
    }

    public LongData getManuever() {
        return manuever;
    }

    public void setManuever(LongData manuever) {
        this.manuever = manuever;
    }

    public LongData getFire() {
        return fire;
    }

    public void setFire(LongData fire) {
        this.fire = fire;
    }

    public LongData getShock() {
        return shock;
    }

    public void setShock(LongData shock) {
        this.shock = shock;
    }

    public TagData getCountry() {
        return country;
    }

    public void setCountry(TagData country) {
        this.country = country;
    }

    public DateData getActivation() {
        return activation;
    }

    public void setActivation(DateData activation) {
        this.activation = activation;
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    @Override
    public void parse(String content) {
        this.name = ParseUtils.parseStringData(content, "name");
        this.dynasty = ParseUtils.parseStringData(content, "dynasty");
        this.type = ParseUtils.parseStringData(content, "type");
        this.manuever = ParseUtils.parseLongData(content, "manuever");
        this.fire = ParseUtils.parseLongData(content, "fire");
        this.shock = ParseUtils.parseLongData(content, "shock");
        this.country = ParseUtils.parseTagData(content, "country");
        this.activation = ParseUtils.parseDateData(content, "activation");

        int i;

        if ((i = content.indexOf("id={")) >= 0) {
            this.id = new IdType(ParseUtils.getNextObject(content, i + 4));
        }

    }
}
