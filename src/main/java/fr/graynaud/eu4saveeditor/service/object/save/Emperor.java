package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Emperor extends Eu4Object {

    private LongData id;

    private TagData country;

    private DateData date;

    public Emperor() {
    }

    public Emperor(String content) {
        parse(content);
    }

    public LongData getId() {
        return id;
    }

    public void setId(LongData id) {
        this.id = id;
    }

    public TagData getCountry() {
        return country;
    }

    public void setCountry(TagData country) {
        this.country = country;
    }

    public DateData getDate() {
        return date;
    }

    public void setDate(DateData date) {
        this.date = date;
    }

    @Override
    public void parse(String content) {
        this.id = ParseUtils.parseProvinceIdData(content, "id");
        this.country = ParseUtils.parseTagData(content, "country");
        this.date = ParseUtils.parseDateData(content, "date");
    }
}
