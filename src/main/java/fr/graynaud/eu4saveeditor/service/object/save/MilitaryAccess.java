package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class MilitaryAccess extends DatableRelation {

    private BoolData enforcePeace;

    public MilitaryAccess() {
    }

    public MilitaryAccess(String content) {
        parse(content);
    }

    public BoolData getEnforcePeace() {
        return enforcePeace;
    }

    public void setEnforcePeace(BoolData enforcePeace) {
        this.enforcePeace = enforcePeace;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.enforcePeace = ParseUtils.parseBoolData(content, "enforce_peace");
    }
}
