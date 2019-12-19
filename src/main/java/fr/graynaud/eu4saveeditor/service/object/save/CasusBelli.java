package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CasusBelli extends DatableRelation {

    private StringData type;

    public CasusBelli() {
    }

    public CasusBelli(String content) {
        parse(content);
    }

    public StringData getType() {
        return type;
    }

    public void setType(StringData type) {
        this.type = type;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.type = ParseUtils.parseStringData(content, "type");
    }
}
