package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DateData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Decree extends Eu4Object {

    private StringData decreeName;

    private DateData decreeDate;

    public StringData getDecreeName() {
        return decreeName;
    }

    public void setDecreeName(StringData decreeName) {
        this.decreeName = decreeName;
    }

    public DateData getDecreeDate() {
        return decreeDate;
    }

    public void setDecreeDate(DateData decreeDate) {
        this.decreeDate = decreeDate;
    }

    @Override
    public void parse(String content) {
        this.decreeName = ParseUtils.parseStringData(content, "decree_name");
        this.decreeDate = ParseUtils.parseDateData(content, "decree_date");
    }
}
