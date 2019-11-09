package fr.graynaud.eu4saveeditor.service.object.save;

import fr.graynaud.eu4saveeditor.service.object.data.*;

public class Meta {

    private DateData date;

    private StringData saveGame;

    private StringData player;

    private StringData displayedCountryName;

    private ObjectData savegameVersion;

    private ListStringData savegameVersions;

    private ListStringData dlcEnabled;

    private ListStringData modEnabled;

    private BoolData multiPlayer;

    private BoolData notObserver;

    private StringData campaignId;

    private IntData campaignLength;

    private ListObjectData campaignStats;

    private StringData checksum;

    public DateData getDate() {
        return date;
    }

    public void setDate(DateData date) {
        this.date = date;
    }

    public StringData getSaveGame() {
        return saveGame;
    }

    public void setSaveGame(StringData saveGame) {
        this.saveGame = saveGame;
    }

    public StringData getPlayer() {
        return player;
    }

    public void setPlayer(StringData player) {
        this.player = player;
    }

    public StringData getDisplayedCountryName() {
        return displayedCountryName;
    }

    public void setDisplayedCountryName(StringData displayedCountryName) {
        this.displayedCountryName = displayedCountryName;
    }

    public ObjectData getSavegameVersion() {
        return savegameVersion;
    }

    public void setSavegameVersion(ObjectData savegameVersion) {
        this.savegameVersion = savegameVersion;
    }

    public ListStringData getSavegameVersions() {
        return savegameVersions;
    }

    public void setSavegameVersions(ListStringData savegameVersions) {
        this.savegameVersions = savegameVersions;
    }

    public ListStringData getDlcEnabled() {
        return dlcEnabled;
    }

    public void setDlcEnabled(ListStringData dlcEnabled) {
        this.dlcEnabled = dlcEnabled;
    }

    public ListStringData getModEnabled() {
        return modEnabled;
    }

    public void setModEnabled(ListStringData modEnabled) {
        this.modEnabled = modEnabled;
    }

    public BoolData getMultiPlayer() {
        return multiPlayer;
    }

    public void setMultiPlayer(BoolData multiPlayer) {
        this.multiPlayer = multiPlayer;
    }

    public BoolData getNotObserver() {
        return notObserver;
    }

    public void setNotObserver(BoolData notObserver) {
        this.notObserver = notObserver;
    }

    public StringData getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(StringData campaignId) {
        this.campaignId = campaignId;
    }

    public IntData getCampaignLength() {
        return campaignLength;
    }

    public void setCampaignLength(IntData campaignLength) {
        this.campaignLength = campaignLength;
    }

    public ListObjectData getCampaignStats() {
        return campaignStats;
    }

    public void setCampaignStats(ListObjectData campaignStats) {
        this.campaignStats = campaignStats;
    }

    public StringData getChecksum() {
        return checksum;
    }

    public void setChecksum(StringData checksum) {
        this.checksum = checksum;
    }
}
