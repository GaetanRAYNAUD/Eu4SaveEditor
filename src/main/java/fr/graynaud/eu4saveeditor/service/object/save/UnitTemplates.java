package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UnitTemplates implements Parsable {

    private IdType id;

    private LongData targetMergeProvince;

    private LongData underConstructionQueued;

    private IdType targetUnitId;

    public UnitTemplates() {
    }

    public UnitTemplates(String content) {
        parse(content);
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public LongData getTargetMergeProvince() {
        return targetMergeProvince;
    }

    public void setTargetMergeProvince(LongData targetMergeProvince) {
        this.targetMergeProvince = targetMergeProvince;
    }

    public LongData getUnderConstructionQueued() {
        return underConstructionQueued;
    }

    public void setUnderConstructionQueued(LongData underConstructionQueued) {
        this.underConstructionQueued = underConstructionQueued;
    }

    public IdType getTargetUnitId() {
        return targetUnitId;
    }

    public void setTargetUnitId(IdType targetUnitId) {
        this.targetUnitId = targetUnitId;
    }

    @Override
    public void parse(String content) {
        int i;

        if ((i = content.indexOf("id={")) >= 0) {
            this.id = new IdType(ParseUtils.getNextObject(content, i + 4));
        }

        this.targetMergeProvince = ParseUtils.parseLongData(content, "target_merge_province");
        this.underConstructionQueued = ParseUtils.parseLongData(content, "under_construction_queued");

        if ((i = content.indexOf("target_unit_id={")) >= 0) {
            this.targetUnitId = new IdType(ParseUtils.getNextObject(content, i + 16));
        }
    }
}
