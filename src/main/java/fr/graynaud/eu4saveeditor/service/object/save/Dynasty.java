package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.ListStringData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Dynasty extends Eu4Object {

    private ListStringData dynasty;

    private CultureGroup cultureGroup;

    public Dynasty() {
    }

    public Dynasty(String content) {
        super(content);
    }

    public ListStringData getDynasty() {
        return dynasty;
    }

    public void setDynasty(ListStringData dynasty) {
        this.dynasty = dynasty;
    }

    public CultureGroup getCultureGroup() {
        return cultureGroup;
    }

    public void setCultureGroup(CultureGroup cultureGroup) {
        this.cultureGroup = cultureGroup;
    }

    @Override
    public void parse(String content) {
        this.dynasty = ParseUtils.parseListStringData(content, "\tdynasty");
        this.cultureGroup = new CultureGroup(content);
    }
}
