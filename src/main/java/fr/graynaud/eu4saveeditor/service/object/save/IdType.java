package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class IdType implements Parsable {

    private LongData id;

    private LongData type;

    public IdType() {
    }

    public IdType(String content) {
        this.parse(content);
    }

    public LongData getId() {
        return id;
    }

    public void setId(LongData id) {
        this.id = id;
    }

    public LongData getType() {
        return type;
    }

    public void setType(LongData type) {
        this.type = type;
    }

    @Override
    public void parse(String content) {
        this.id = ParseUtils.parseLongData(content, "id");
        this.type = ParseUtils.parseLongData(content, "type");
    }
}
