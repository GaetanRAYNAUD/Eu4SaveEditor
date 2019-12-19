package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Papacy extends Eu4Object {

    private TagData papalState;

    private LongData weightedCardinal;

    public Papacy() {
    }

    public Papacy(String content) {
        parse(content);
    }

    public TagData getPapalState() {
        return papalState;
    }

    public void setPapalState(TagData papalState) {
        this.papalState = papalState;
    }

    public LongData getWeightedCardinal() {
        return weightedCardinal;
    }

    public void setWeightedCardinal(LongData weightedCardinal) {
        this.weightedCardinal = weightedCardinal;
    }

    @Override
    public void parse(String content) {
        content = ParseUtils.getNextObject(content, content.indexOf("papacy") + 1);
        this.papalState = ParseUtils.parseTagData(content, "papal_state");
        this.weightedCardinal = ParseUtils.parseLongData(content, "weighted_cardinal");
    }
}
