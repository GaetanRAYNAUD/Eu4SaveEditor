package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Diplomacy extends Eu4Object {

    private List<Dependency> dependencies;

    private List<CasusBelli> casusBelli;

    private List<EnvoyDatableRelation> counterEspionage;

    private List<EnvoyDatableRelation> improveRelations;

    private List<DatableRelation> royalMarriages;

    private List<DatableRelation> alliances;

    private List<MilitaryAccess> militaryAccesses;

    private List<Condottieri> condottieri;

    private List<DatableRelation> annulTreaties;

    private List<DatableRelation> guarantees;

    private List<ConcedeColonialRegion> concedeColonialRegions;

    private List<TransferTradePower> transferTradePower;

    private List<KnowledgeSharing> knowledgeSharing;

    private List<EndDatableRelation> warReparations;

    private List<DatableRelation> supportIndependence;

    private List<Subsidies> subsidies;

    private List<DatableRelation> warnings;

    public Diplomacy() {
    }

    public Diplomacy(String content) {
        super(content);
    }

    public List<Dependency> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public List<CasusBelli> getCasusBelli() {
        return casusBelli;
    }

    public void setCasusBelli(List<CasusBelli> casusBelli) {
        this.casusBelli = casusBelli;
    }

    public List<EnvoyDatableRelation> getCounterEspionage() {
        return counterEspionage;
    }

    public void setCounterEspionage(List<EnvoyDatableRelation> counterEspionage) {
        this.counterEspionage = counterEspionage;
    }

    public List<EnvoyDatableRelation> getImproveRelations() {
        return improveRelations;
    }

    public void setImproveRelations(List<EnvoyDatableRelation> improveRelations) {
        this.improveRelations = improveRelations;
    }

    public List<DatableRelation> getRoyalMarriages() {
        return royalMarriages;
    }

    public void setRoyalMarriages(List<DatableRelation> royalMarriages) {
        this.royalMarriages = royalMarriages;
    }

    public List<DatableRelation> getAlliances() {
        return alliances;
    }

    public void setAlliances(List<DatableRelation> alliances) {
        this.alliances = alliances;
    }

    public List<MilitaryAccess> getMilitaryAccesses() {
        return militaryAccesses;
    }

    public void setMilitaryAccesses(List<MilitaryAccess> militaryAccesses) {
        this.militaryAccesses = militaryAccesses;
    }

    public List<Condottieri> getCondottieri() {
        return condottieri;
    }

    public void setCondottieri(List<Condottieri> condottieri) {
        this.condottieri = condottieri;
    }

    public List<DatableRelation> getAnnulTreaties() {
        return annulTreaties;
    }

    public void setAnnulTreaties(List<DatableRelation> annulTreaties) {
        this.annulTreaties = annulTreaties;
    }

    public List<DatableRelation> getGuarantees() {
        return guarantees;
    }

    public void setGuarantees(List<DatableRelation> guarantees) {
        this.guarantees = guarantees;
    }

    public List<ConcedeColonialRegion> getConcedeColonialRegions() {
        return concedeColonialRegions;
    }

    public void setConcedeColonialRegions(List<ConcedeColonialRegion> concedeColonialRegions) {
        this.concedeColonialRegions = concedeColonialRegions;
    }

    public List<TransferTradePower> getTransferTradePower() {
        return transferTradePower;
    }

    public void setTransferTradePower(List<TransferTradePower> transferTradePower) {
        this.transferTradePower = transferTradePower;
    }

    public List<KnowledgeSharing> getKnowledgeSharing() {
        return knowledgeSharing;
    }

    public void setKnowledgeSharing(List<KnowledgeSharing> knowledgeSharing) {
        this.knowledgeSharing = knowledgeSharing;
    }

    public List<EndDatableRelation> getWarReparations() {
        return warReparations;
    }

    public void setWarReparations(List<EndDatableRelation> warReparations) {
        this.warReparations = warReparations;
    }

    public List<DatableRelation> getSupportIndependence() {
        return supportIndependence;
    }

    public void setSupportIndependence(List<DatableRelation> supportIndependence) {
        this.supportIndependence = supportIndependence;
    }

    public List<Subsidies> getSubsidies() {
        return subsidies;
    }

    public void setSubsidies(List<Subsidies> subsidies) {
        this.subsidies = subsidies;
    }

    public List<DatableRelation> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<DatableRelation> warnings) {
        this.warnings = warnings;
    }

    @Override
    public void parse(String content) {
        content = ParseUtils.getNextObject(content, content.indexOf("\ndiplomacy={"));
        this.dependencies = ParseUtils.getListSameObject(content, "dependency").stream().map(Dependency::new).collect(Collectors.toList());
        this.casusBelli = ParseUtils.getListSameObject(content, "casus_belli").stream().map(CasusBelli::new).collect(Collectors.toList());
        this.counterEspionage = ParseUtils.getListSameObject(content, "counterespionage").stream().map(EnvoyDatableRelation::new).collect(Collectors.toList());
        this.improveRelations = ParseUtils.getListSameObject(content, "improve_relation").stream().map(EnvoyDatableRelation::new).collect(Collectors.toList());
        this.royalMarriages = ParseUtils.getListSameObject(content, "royal_marriage").stream().map(DatableRelation::new).collect(Collectors.toList());
        this.alliances = ParseUtils.getListSameObject(content, "alliance").stream().map(DatableRelation::new).collect(Collectors.toList());
        this.militaryAccesses = ParseUtils.getListSameObject(content, "military_access").stream().map(MilitaryAccess::new).collect(Collectors.toList());
        this.condottieri = ParseUtils.getListSameObject(content, "condottieri").stream().map(Condottieri::new).collect(Collectors.toList());
        this.annulTreaties = ParseUtils.getListSameObject(content, "annul_treaties").stream().map(DatableRelation::new).collect(Collectors.toList());
        this.guarantees = ParseUtils.getListSameObject(content, "guarantee").stream().map(DatableRelation::new).collect(Collectors.toList());
        this.concedeColonialRegions = ParseUtils.getListSameObject(content, "concede_colonial_region").stream().map(ConcedeColonialRegion::new).collect(Collectors.toList());
        this.transferTradePower = ParseUtils.getListSameObject(content, "transfer_trade_power").stream().map(TransferTradePower::new).collect(Collectors.toList());
        this.knowledgeSharing = ParseUtils.getListSameObject(content, "knowledge_sharing").stream().map(KnowledgeSharing::new).collect(Collectors.toList());
        this.warReparations = ParseUtils.getListSameObject(content, "war_reparations").stream().map(EndDatableRelation::new).collect(Collectors.toList());
        this.supportIndependence = ParseUtils.getListSameObject(content, "support_independence").stream().map(DatableRelation::new).collect(Collectors.toList());
        this.subsidies = ParseUtils.getListSameObject(content, "subsidies").stream().map(Subsidies::new).collect(Collectors.toList());
        this.warnings = ParseUtils.getListSameObject(content, "warning").stream().map(DatableRelation::new).collect(Collectors.toList());
    }
}
