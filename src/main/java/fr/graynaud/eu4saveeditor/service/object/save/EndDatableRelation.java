package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class EndDatableRelation extends DatableRelation {

    private DateData endDate;

    public EndDatableRelation() {
    }

    public EndDatableRelation(String content) {
        parse(content);
    }

    public DateData getEndDate() {
        return endDate;
    }

    public void setEndDate(DateData endDate) {
        this.endDate = endDate;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.endDate = ParseUtils.parseDateData(content, "end_date");
    }
}
