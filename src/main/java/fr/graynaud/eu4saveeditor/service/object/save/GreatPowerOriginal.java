package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GreatPowerOriginal extends Eu4Object {

    private LongData rank;

    private TagData country;

    private DoubleData value;

    public LongData getRank() {
        return rank;
    }

    public void setRank(LongData rank) {
        this.rank = rank;
    }

    public TagData getCountry() {
        return country;
    }

    public void setCountry(TagData country) {
        this.country = country;
    }

    public DoubleData getValue() {
        return value;
    }

    public void setValue(DoubleData value) {
        this.value = value;
    }

    @Override
    public void parse(String content) {
        this.rank = ParseUtils.parseLongData(content, "rank");
        this.country = ParseUtils.parseTagData(content, "country");
        this.value = ParseUtils.parseDoubleData(content, "value");
    }
}
