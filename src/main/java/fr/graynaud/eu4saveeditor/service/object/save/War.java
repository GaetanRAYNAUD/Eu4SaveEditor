package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class War extends Eu4Object {

    private StringData name;

    private WarHistory history;

    private List<WarParticipant> participants;

    private LineTagData persistentAttackers;

    private LineTagData persistentDefenders;

    private TagData originalAttacker;

    private TagData originalDefender;

    private DateData action;

    private LongData warDirectionQuarter;

    private LongData lastWarscoreQuarter;

    private LongData lastWarscoreYear;

    private DateData nextQuarterUpdate;

    private DateData nextYearUpdate;

    private LongData stalledYears;

    public War() {
    }

    public War(String content) {
        parse(content);
    }

    public StringData getName() {
        return name;
    }

    public void setName(StringData name) {
        this.name = name;
    }

    public WarHistory getHistory() {
        return history;
    }

    public void setHistory(WarHistory history) {
        this.history = history;
    }

    public List<WarParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<WarParticipant> participants) {
        this.participants = participants;
    }

    public LineTagData getPersistentAttackers() {
        return persistentAttackers;
    }

    public void setPersistentAttackers(LineTagData persistentAttackers) {
        this.persistentAttackers = persistentAttackers;
    }

    public LineTagData getPersistentDefenders() {
        return persistentDefenders;
    }

    public void setPersistentDefenders(LineTagData persistentDefenders) {
        this.persistentDefenders = persistentDefenders;
    }

    public TagData getOriginalAttacker() {
        return originalAttacker;
    }

    public void setOriginalAttacker(TagData originalAttacker) {
        this.originalAttacker = originalAttacker;
    }

    public TagData getOriginalDefender() {
        return originalDefender;
    }

    public void setOriginalDefender(TagData originalDefender) {
        this.originalDefender = originalDefender;
    }

    public DateData getAction() {
        return action;
    }

    public void setAction(DateData action) {
        this.action = action;
    }

    public LongData getWarDirectionQuarter() {
        return warDirectionQuarter;
    }

    public void setWarDirectionQuarter(LongData warDirectionQuarter) {
        this.warDirectionQuarter = warDirectionQuarter;
    }

    public LongData getLastWarscoreQuarter() {
        return lastWarscoreQuarter;
    }

    public void setLastWarscoreQuarter(LongData lastWarscoreQuarter) {
        this.lastWarscoreQuarter = lastWarscoreQuarter;
    }

    public LongData getLastWarscoreYear() {
        return lastWarscoreYear;
    }

    public void setLastWarscoreYear(LongData lastWarscoreYear) {
        this.lastWarscoreYear = lastWarscoreYear;
    }

    public DateData getNextQuarterUpdate() {
        return nextQuarterUpdate;
    }

    public void setNextQuarterUpdate(DateData nextQuarterUpdate) {
        this.nextQuarterUpdate = nextQuarterUpdate;
    }

    public DateData getNextYearUpdate() {
        return nextYearUpdate;
    }

    public void setNextYearUpdate(DateData nextYearUpdate) {
        this.nextYearUpdate = nextYearUpdate;
    }

    public LongData getStalledYears() {
        return stalledYears;
    }

    public void setStalledYears(LongData stalledYears) {
        this.stalledYears = stalledYears;
    }

    @Override
    public void parse(String content) {
        this.name = ParseUtils.parseStringData(content, "name");
        this.history = new WarHistory(content);
        this.participants = ParseUtils.getListSameObject(content, "participants")
                                      .stream()
                                      .map(WarParticipant::new)
                                      .collect(Collectors.toList());
        this.persistentAttackers = ParseUtils.parseLineTagData(content, "persistent_attackers");
        this.persistentDefenders = ParseUtils.parseLineTagData(content, "persistent_defenders");
        this.originalAttacker = ParseUtils.parseTagData(content, "original_attacker");
        this.originalDefender = ParseUtils.parseTagData(content, "original_defender");
        this.action = ParseUtils.parseDateData(content, "action");
        this.warDirectionQuarter = ParseUtils.parseLongData(content, "war_direction_quarter");
        this.lastWarscoreQuarter = ParseUtils.parseLongData(content, "last_warscore_quarter");
        this.lastWarscoreYear = ParseUtils.parseLongData(content, "last_warscore_year");
        this.nextQuarterUpdate = ParseUtils.parseDateData(content, "next_quarter_update");
        this.nextYearUpdate = ParseUtils.parseDateData(content, "next_year_update");
        this.stalledYears = ParseUtils.parseLongData(content, "stalled_years");
    }
}
