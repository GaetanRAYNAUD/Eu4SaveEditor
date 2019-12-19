package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WarParticipant extends Eu4Object {

    private DoubleData value;

    private TagData tag;

    private BoolData promisedLand;

    private LineLongData losses;

    public WarParticipant() {
    }

    public WarParticipant(String content) {
        super(content);
    }

    public DoubleData getValue() {
        return value;
    }

    public void setValue(DoubleData value) {
        this.value = value;
    }

    public TagData getTag() {
        return tag;
    }

    public void setTag(TagData tag) {
        this.tag = tag;
    }

    public BoolData getPromisedLand() {
        return promisedLand;
    }

    public void setPromisedLand(BoolData promisedLand) {
        this.promisedLand = promisedLand;
    }

    public LineLongData getLosses() {
        return losses;
    }

    public void setLosses(LineLongData losses) {
        this.losses = losses;
    }

    @Override
    public void parse(String content) {
        this.value = ParseUtils.parseDoubleData(content, "value");
        this.tag = ParseUtils.parseTagData(content, "tag");
        this.promisedLand = ParseUtils.parseBoolData(content, "promised_land");
        this.losses = ParseUtils.parseLineLongData(content, "members");
    }
}
