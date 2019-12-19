package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class DatableRelation extends Eu4Object {

    private TagData first;

    private TagData second;

    private DateData startDate;

    public DatableRelation() {
    }

    public DatableRelation(String content) {
        parse(content);
    }

    public TagData getFirst() {
        return first;
    }

    public void setFirst(TagData first) {
        this.first = first;
    }

    public TagData getSecond() {
        return second;
    }

    public void setSecond(TagData second) {
        this.second = second;
    }

    public DateData getStartDate() {
        return startDate;
    }

    public void setStartDate(DateData startDate) {
        this.startDate = startDate;
    }

    @Override
    public void parse(String content) {
        this.first = ParseUtils.parseTagData(content, "first");
        this.second = ParseUtils.parseTagData(content, "second");
        this.startDate = ParseUtils.parseDateData(content, "start_date");
    }
}
