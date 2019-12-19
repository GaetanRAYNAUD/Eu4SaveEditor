package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ConcedeColonialRegion extends DatableRelation {

    private StringData region;

    public ConcedeColonialRegion() {
    }

    public ConcedeColonialRegion(String content) {
        parse(content);
    }

    public StringData getRegion() {
        return region;
    }

    public void setRegion(StringData region) {
        this.region = region;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.region = ParseUtils.parseStringData(content, "\tregion");
    }
}
