package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class KnowledgeSharing extends EndDatableRelation {

    private BoolData subjectInteractions;

    public KnowledgeSharing() {
    }

    public KnowledgeSharing(String content) {
        parse(content);
    }

    public BoolData getSubjectInteractions() {
        return subjectInteractions;
    }

    public void setSubjectInteractions(BoolData subjectInteractions) {
        this.subjectInteractions = subjectInteractions;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.subjectInteractions = ParseUtils.parseBoolData(content, "subject_interactions");
    }
}
