package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Condottieri extends QuantifyDatableRelation {

    private IdType unit;

    private DoubleData participation;

    public Condottieri() {
    }

    public Condottieri(String content) {
        parse(content);
    }

    public IdType getUnit() {
        return unit;
    }

    public void setUnit(IdType unit) {
        this.unit = unit;
    }

    public DoubleData getParticipation() {
        return participation;
    }

    public void setParticipation(DoubleData participation) {
        this.participation = participation;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.unit = new IdType(ParseUtils.getNextObject(content, content.indexOf("unit={")));
        this.participation = ParseUtils.parseDoubleData(content, "participation");
    }
}
