package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Dependency extends DatableRelation {

    private StringData subjectType;

    public Dependency() {
    }

    public Dependency(String content) {
        parse(content);
    }

    public StringData getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(StringData subjectType) {
        this.subjectType = subjectType;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.subjectType = ParseUtils.parseStringData(content, "subject_type");
    }
}
