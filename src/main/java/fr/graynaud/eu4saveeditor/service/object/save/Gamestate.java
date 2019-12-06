package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Gamestate implements Parsable {

    private ListStringData playersCountries;

    private GameplaySettings gameplaySettings;

    private ListStringData usedClientNames;

    private LongData speed;

    private LongData multiplayerRandomSeed;

    private LongData multiplayerRandomCount;

    private StringData currentAge;

    private DoubleData nextAgeProgress;

    private LineLongData idCounters;

    private LongData unit;

    private LongData unitTemplateId;

    private SavedEventTarget savedEventTarget;

    private Flags flags;

    private DateData startDate;

    private ObjectData mapAreaData;

    private DoubleData totalMilitaryPower;

    private DoubleData averageMilitaryPower;

    private LineProvinceIdData institutionOrigin;

    private LineLongData institutions;

    private LineDoubleData institutionsPenalties;

    private NotParsedData trade;

    private List<UnitTemplates> unitTemplates;

    private LineTagData productionLeaderTag;

    private LineTagData dynamicCountries;

    private LineDoubleData tradeGoodsTotalProduced;

    private ChangePrice changePrice;

    private List<IdType> id;

    private Dynasty dynasty;

    private List<RebelFaction> rebelFaction;

    private GreatPowers greatPowers;

    private Hre empire;

    private CelestialEmpire celestialEmpire;

    private LongData hreLeaguesStatus;

    private LongData hreReligionStatus;

    private List<TradeLeague> tradeLeague;

    private Religions religions;

    private ObjectData religionInstanceData;

    private FiredEvents firedEvents;

    private PendingEvents pendingEvents;

    private ObjectData provinces;

    private ObjectData countries;

    private ObjectData activeAdvisors;

    private ObjectData diplomacy;

    private ObjectData combat;

    private ObjectData activeWar;

    private ObjectData previousWar;

    private NotParsedData incomeStatistics;

    private NotParsedData nationSizeStatistics;

    private NotParsedData scoreStatistics;

    private NotParsedData inflationStatistics;

    private AutoFleetTransport autoFleetTransport;

    private LineLongData expandedDipActionGroups;

    private NotParsedData selectionGroups;

    private BoolData achievementOk;

    private ObjectData unitManager;

    private TradeCompanyManager tradeCompanyManager;

    private TechLevelDates techLevelDates;

    private IdeaDates ideaDates;

    private StringData checksum;

    public ListStringData getPlayersCountries() {
        return playersCountries;
    }

    public void setPlayersCountries(ListStringData playersCountries) {
        this.playersCountries = playersCountries;
    }

    public GameplaySettings getGameplaySettings() {
        return gameplaySettings;
    }

    public void setGameplaySettings(GameplaySettings gameplaySettings) {
        this.gameplaySettings = gameplaySettings;
    }

    public ListStringData getUsedClientNames() {
        return usedClientNames;
    }

    public void setUsedClientNames(ListStringData usedClientNames) {
        this.usedClientNames = usedClientNames;
    }

    public LongData getSpeed() {
        return speed;
    }

    public void setSpeed(LongData speed) {
        this.speed = speed;
    }

    public LongData getMultiplayerRandomSeed() {
        return multiplayerRandomSeed;
    }

    public void setMultiplayerRandomSeed(LongData multiplayerRandomSeed) {
        this.multiplayerRandomSeed = multiplayerRandomSeed;
    }

    public LongData getMultiplayerRandomCount() {
        return multiplayerRandomCount;
    }

    public void setMultiplayerRandomCount(LongData multiplayerRandomCount) {
        this.multiplayerRandomCount = multiplayerRandomCount;
    }

    public StringData getCurrentAge() {
        return currentAge;
    }

    public void setCurrentAge(StringData currentAge) {
        this.currentAge = currentAge;
    }

    public DoubleData getNextAgeProgress() {
        return nextAgeProgress;
    }

    public void setNextAgeProgress(DoubleData nextAgeProgress) {
        this.nextAgeProgress = nextAgeProgress;
    }

    public LineLongData getIdCounters() {
        return idCounters;
    }

    public void setIdCounters(LineLongData idCounters) {
        this.idCounters = idCounters;
    }

    public LongData getUnit() {
        return unit;
    }

    public void setUnit(LongData unit) {
        this.unit = unit;
    }

    public LongData getUnitTemplateId() {
        return unitTemplateId;
    }

    public void setUnitTemplateId(LongData unitTemplateId) {
        this.unitTemplateId = unitTemplateId;
    }

    public SavedEventTarget getSavedEventTarget() {
        return savedEventTarget;
    }

    public void setSavedEventTarget(SavedEventTarget savedEventTarget) {
        this.savedEventTarget = savedEventTarget;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public DateData getStartDate() {
        return startDate;
    }

    public void setStartDate(DateData startDate) {
        this.startDate = startDate;
    }

    public ObjectData getMapAreaData() {
        return mapAreaData;
    }

    public void setMapAreaData(ObjectData mapAreaData) {
        this.mapAreaData = mapAreaData;
    }

    public DoubleData getTotalMilitaryPower() {
        return totalMilitaryPower;
    }

    public void setTotalMilitaryPower(DoubleData totalMilitaryPower) {
        this.totalMilitaryPower = totalMilitaryPower;
    }

    public DoubleData getAverageMilitaryPower() {
        return averageMilitaryPower;
    }

    public void setAverageMilitaryPower(DoubleData averageMilitaryPower) {
        this.averageMilitaryPower = averageMilitaryPower;
    }

    public LineProvinceIdData getInstitutionOrigin() {
        return institutionOrigin;
    }

    public void setInstitutionOrigin(LineProvinceIdData institutionOrigin) {
        this.institutionOrigin = institutionOrigin;
    }

    public LineLongData getInstitutions() {
        return institutions;
    }

    public void setInstitutions(LineLongData institutions) {
        this.institutions = institutions;
    }

    public LineDoubleData getInstitutionsPenalties() {
        return institutionsPenalties;
    }

    public void setInstitutionsPenalties(LineDoubleData institutionsPenalties) {
        this.institutionsPenalties = institutionsPenalties;
    }

    public NotParsedData getTrade() {
        return trade;
    }

    public void setTrade(NotParsedData trade) {
        this.trade = trade;
    }

    public List<UnitTemplates> getUnitTemplates() {
        return unitTemplates;
    }

    public void setUnitTemplates(List<UnitTemplates> unitTemplates) {
        this.unitTemplates = unitTemplates;
    }

    public LineTagData getProductionLeaderTag() {
        return productionLeaderTag;
    }

    public void setProductionLeaderTag(LineTagData productionLeaderTag) {
        this.productionLeaderTag = productionLeaderTag;
    }

    public LineTagData getDynamicCountries() {
        return dynamicCountries;
    }

    public void setDynamicCountries(LineTagData dynamicCountries) {
        this.dynamicCountries = dynamicCountries;
    }

    public LineDoubleData getTradeGoodsTotalProduced() {
        return tradeGoodsTotalProduced;
    }

    public void setTradeGoodsTotalProduced(LineDoubleData tradeGoodsTotalProduced) {
        this.tradeGoodsTotalProduced = tradeGoodsTotalProduced;
    }

    public ChangePrice getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(ChangePrice changePrice) {
        this.changePrice = changePrice;
    }

    public List<IdType> getId() {
        return id;
    }

    public void setId(List<IdType> id) {
        this.id = id;
    }

    public Dynasty getDynasty() {
        return dynasty;
    }

    public void setDynasty(Dynasty dynasty) {
        this.dynasty = dynasty;
    }

    public List<RebelFaction> getRebelFaction() {
        return rebelFaction;
    }

    public void setRebelFaction(List<RebelFaction> rebelFaction) {
        this.rebelFaction = rebelFaction;
    }

    public GreatPowers getGreatPowers() {
        return greatPowers;
    }

    public void setGreatPowers(GreatPowers greatPowers) {
        this.greatPowers = greatPowers;
    }

    public Hre getEmpire() {
        return empire;
    }

    public void setEmpire(Hre empire) {
        this.empire = empire;
    }

    public CelestialEmpire getCelestialEmpire() {
        return celestialEmpire;
    }

    public void setCelestialEmpire(CelestialEmpire celestialEmpire) {
        this.celestialEmpire = celestialEmpire;
    }

    public LongData getHreLeaguesStatus() {
        return hreLeaguesStatus;
    }

    public void setHreLeaguesStatus(LongData hreLeaguesStatus) {
        this.hreLeaguesStatus = hreLeaguesStatus;
    }

    public LongData getHreReligionStatus() {
        return hreReligionStatus;
    }

    public void setHreReligionStatus(LongData hreReligionStatus) {
        this.hreReligionStatus = hreReligionStatus;
    }

    public List<TradeLeague> getTradeLeague() {
        return tradeLeague;
    }

    public void setTradeLeague(List<TradeLeague> tradeLeague) {
        this.tradeLeague = tradeLeague;
    }

    public Religions getReligions() {
        return religions;
    }

    public void setReligions(Religions religions) {
        this.religions = religions;
    }

    public ObjectData getReligionInstanceData() {
        return religionInstanceData;
    }

    public void setReligionInstanceData(ObjectData religionInstanceData) {
        this.religionInstanceData = religionInstanceData;
    }

    public FiredEvents getFiredEvents() {
        return firedEvents;
    }

    public void setFiredEvents(FiredEvents firedEvents) {
        this.firedEvents = firedEvents;
    }

    public PendingEvents getPendingEvents() {
        return pendingEvents;
    }

    public void setPendingEvents(PendingEvents pendingEvents) {
        this.pendingEvents = pendingEvents;
    }

    public ObjectData getProvinces() {
        return provinces;
    }

    public void setProvinces(ObjectData provinces) {
        this.provinces = provinces;
    }

    public ObjectData getCountries() {
        return countries;
    }

    public void setCountries(ObjectData countries) {
        this.countries = countries;
    }

    public ObjectData getActiveAdvisors() {
        return activeAdvisors;
    }

    public void setActiveAdvisors(ObjectData activeAdvisors) {
        this.activeAdvisors = activeAdvisors;
    }

    public ObjectData getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(ObjectData diplomacy) {
        this.diplomacy = diplomacy;
    }

    public ObjectData getCombat() {
        return combat;
    }

    public void setCombat(ObjectData combat) {
        this.combat = combat;
    }

    public ObjectData getActiveWar() {
        return activeWar;
    }

    public void setActiveWar(ObjectData activeWar) {
        this.activeWar = activeWar;
    }

    public ObjectData getPreviousWar() {
        return previousWar;
    }

    public void setPreviousWar(ObjectData previousWar) {
        this.previousWar = previousWar;
    }

    public NotParsedData getIncomeStatistics() {
        return incomeStatistics;
    }

    public void setIncomeStatistics(NotParsedData incomeStatistics) {
        this.incomeStatistics = incomeStatistics;
    }

    public NotParsedData getNationSizeStatistics() {
        return nationSizeStatistics;
    }

    public void setNationSizeStatistics(NotParsedData nationSizeStatistics) {
        this.nationSizeStatistics = nationSizeStatistics;
    }

    public NotParsedData getScoreStatistics() {
        return scoreStatistics;
    }

    public void setScoreStatistics(NotParsedData scoreStatistics) {
        this.scoreStatistics = scoreStatistics;
    }

    public NotParsedData getInflationStatistics() {
        return inflationStatistics;
    }

    public void setInflationStatistics(NotParsedData inflationStatistics) {
        this.inflationStatistics = inflationStatistics;
    }

    public AutoFleetTransport getAutoFleetTransport() {
        return autoFleetTransport;
    }

    public void setAutoFleetTransport(AutoFleetTransport autoFleetTransport) {
        this.autoFleetTransport = autoFleetTransport;
    }

    public LineLongData getExpandedDipActionGroups() {
        return expandedDipActionGroups;
    }

    public void setExpandedDipActionGroups(LineLongData expandedDipActionGroups) {
        this.expandedDipActionGroups = expandedDipActionGroups;
    }

    public NotParsedData getSelectionGroups() {
        return selectionGroups;
    }

    public void setSelectionGroups(NotParsedData selectionGroups) {
        this.selectionGroups = selectionGroups;
    }

    public BoolData getAchievementOk() {
        return achievementOk;
    }

    public void setAchievementOk(BoolData achievementOk) {
        this.achievementOk = achievementOk;
    }

    public ObjectData getUnitManager() {
        return unitManager;
    }

    public void setUnitManager(ObjectData unitManager) {
        this.unitManager = unitManager;
    }

    public TradeCompanyManager getTradeCompanyManager() {
        return tradeCompanyManager;
    }

    public void setTradeCompanyManager(TradeCompanyManager tradeCompanyManager) {
        this.tradeCompanyManager = tradeCompanyManager;
    }

    public TechLevelDates getTechLevelDates() {
        return techLevelDates;
    }

    public void setTechLevelDates(TechLevelDates techLevelDates) {
        this.techLevelDates = techLevelDates;
    }

    public IdeaDates getIdeaDates() {
        return ideaDates;
    }

    public void setIdeaDates(IdeaDates ideaDates) {
        this.ideaDates = ideaDates;
    }

    public StringData getChecksum() {
        return checksum;
    }

    public void setChecksum(StringData checksum) {
        this.checksum = checksum;
    }

    @Override
    public void parse(String content) {
        int indexOfProvinces = content.indexOf("\nprovinces={");
        int indexOfCountries = content.indexOf("\ncountries={", indexOfProvinces);
        int indexOfEnd = content.indexOf("\nactive_advisors={", indexOfCountries);
        String startContent = content.substring(0, indexOfProvinces).trim();
        String provincesContent = content.substring(indexOfProvinces, indexOfCountries - 1).trim();
        String countriesContent = content.substring(indexOfCountries, indexOfEnd - 1).trim();
        String endContent = content.substring(indexOfEnd).trim();

        this.playersCountries = ParseUtils.parseListStringData(startContent, "players_countries");
        this.gameplaySettings = new GameplaySettings(startContent);
        this.usedClientNames = ParseUtils.parseListStringData(startContent, "used_client_names");
        this.speed = ParseUtils.parseLongData(startContent, "speed");
        this.multiplayerRandomSeed = ParseUtils.parseLongData(startContent, "multiplayer_random_seed");
        this.multiplayerRandomCount = ParseUtils.parseLongData(startContent, "multiplayer_random_count");
        this.currentAge = ParseUtils.parseStringData(startContent, "current_age");
        this.nextAgeProgress = ParseUtils.parseDoubleData(startContent, "next_age_progress");
        this.idCounters = ParseUtils.parseLineLongData(startContent, "id_counters");
        this.unit = ParseUtils.parseLongData(startContent, "unit");
        this.unitTemplateId = ParseUtils.parseLongData(startContent, "unit_template_id");
        this.savedEventTarget = new SavedEventTarget(startContent);
        this.flags = new Flags(content);
        this.startDate = ParseUtils.parseDateData(startContent, "start_date");
        //        this.mapAreaData = ParseUtils.parseObjectData(startContent, "");
        this.totalMilitaryPower = ParseUtils.parseDoubleData(startContent, "total_military_power");
        this.averageMilitaryPower = ParseUtils.parseDoubleData(startContent, "average_military_power");
        this.institutionOrigin = ParseUtils.parseLineProvinceIdData(startContent, "institution_origin");
        this.institutions = ParseUtils.parseLineLongData(startContent, "institutions");
        this.institutionsPenalties = ParseUtils.parseLineDoubleData(startContent, "institutions_penalties");
        //        this.trade = ParseUtils.parseNotParsedData(startContent, "");
        this.unitTemplates = ParseUtils.getListSameObject(startContent, "unit_templates")
                                       .stream()
                                       .map(UnitTemplates::new)
                                       .collect(Collectors.toList());
        this.productionLeaderTag = ParseUtils.parseLineTagData(startContent, "production_leader_tag");
        this.dynamicCountries = ParseUtils.parseLineTagData(startContent, "dynamic_countries");
        this.tradeGoodsTotalProduced = ParseUtils.parseLineDoubleData(startContent, "tradegoods_total_produced");
        this.changePrice = new ChangePrice(startContent);
        this.id = ParseUtils.getListSameObject(startContent, "\nid={")
                            .stream()
                            .map(s -> new IdType(s.substring(s.indexOf("id={") + 1)))
                            .collect(Collectors.toList());
        this.dynasty = new Dynasty(content);
        this.rebelFaction = ParseUtils.getListSameObject(startContent, "\nrebel_faction={")
                                      .stream()
                                      .map(RebelFaction::new)
                                      .collect(Collectors.toList());
        this.greatPowers = new GreatPowers(startContent);
        this.empire = new Hre(startContent);
        this.celestialEmpire = new CelestialEmpire(startContent);
        this.hreLeaguesStatus = ParseUtils.parseLongData(startContent, "hre_leagues_status");
        this.hreReligionStatus = ParseUtils.parseLongData(startContent, "hre_religion_status");
        this.tradeLeague = ParseUtils.getListSameObject(startContent, "\ntrade_league={")
                                     .stream()
                                     .map(TradeLeague::new)
                                     .collect(Collectors.toList());
        this.religions = new Religions(startContent);
        //        this.religionInstanceData = ParseUtils.parseObjectData(startContent, "");
        this.firedEvents = new FiredEvents(startContent);
        this.pendingEvents = new PendingEvents(startContent);
        //        this.provinces = ParseUtils.parseObjectData(startContent, "");
        //        this.countries = ParseUtils.parseObjectData(startContent, "");
        //        this.activeAdvisors = ParseUtils.parseObjectData(startContent, "");
        //        this.diplomacy = ParseUtils.parseObjectData(startContent, "");
        //        this.combat = ParseUtils.parseObjectData(startContent, "");
        //        this.activeWar = ParseUtils.parseObjectData(startContent, "");
        //        this.previousWar = ParseUtils.parseObjectData(startContent, "");
        //        this.incomeStatistics = ParseUtils.parseNotParsedData(startContent, "");
        //        this.nationSizeStatistics = ParseUtils.parseNotParsedData(startContent, "");
        //        this.scoreStatistics = ParseUtils.parseNotParsedData(startContent, "");
        //        this.inflationStatistics = ParseUtils.parseNotParsedData(startContent, "");
        this.autoFleetTransport = new AutoFleetTransport(endContent);
        this.expandedDipActionGroups = ParseUtils.parseLineLongData(endContent, "expanded_dip_action_groups");
        //        this.selectionGroups = ParseUtils.parseNotParsedData(startContent, "");
        this.achievementOk = ParseUtils.parseBoolData(endContent, "achievement_ok");
        //        this.unitManager = ParseUtils.parseObjectData(startContent, "");
        this.tradeCompanyManager = new TradeCompanyManager(endContent);
        this.techLevelDates = new TechLevelDates(endContent);
        this.ideaDates = new IdeaDates(endContent);
        this.checksum = ParseUtils.parseStringData(endContent, "checksum");
    }
}
