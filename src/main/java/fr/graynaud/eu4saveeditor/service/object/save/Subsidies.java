package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Subsidies extends QuantifyDatableRelation {

    private LongData duration;

    public Subsidies() {
    }

    public Subsidies(String content) {
        parse(content);
    }

    public LongData getDuration() {
        return duration;
    }

    public void setDuration(LongData duration) {
        this.duration = duration;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.duration = ParseUtils.parseLongData(content, "duration");
    }
}
