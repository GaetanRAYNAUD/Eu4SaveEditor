package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class PreviousWar extends War {

    private DoubleData defenderScore;

    private LongData outcome;

    public PreviousWar() {
    }

    public PreviousWar(String content) {
        parse(content);
    }

    public DoubleData getDefenderScore() {
        return defenderScore;
    }

    public void setDefenderScore(DoubleData defenderScore) {
        this.defenderScore = defenderScore;
    }

    public LongData getOutcome() {
        return outcome;
    }

    public void setOutcome(LongData outcome) {
        this.outcome = outcome;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.defenderScore = ParseUtils.parseDoubleData(content, "defender_score");
        this.outcome = ParseUtils.parseLongData(content, "outcome");
    }
}
