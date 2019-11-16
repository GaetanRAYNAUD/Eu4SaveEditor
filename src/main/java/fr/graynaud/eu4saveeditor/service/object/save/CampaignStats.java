package fr.graynaud.eu4saveeditor.service.object.save;

import fr.graynaud.eu4saveeditor.service.object.data.FloatData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

public class CampaignStats {

    private LongData id;

    private LongData comparison;

    private StringData key;

    private StringData localization;

    private FloatData value;

    private LongData sampleCount;

    public LongData getId() {
        return id;
    }

    public void setId(LongData id) {
        this.id = id;
    }

    public LongData getComparison() {
        return comparison;
    }

    public void setComparison(LongData comparison) {
        this.comparison = comparison;
    }

    public StringData getKey() {
        return key;
    }

    public void setKey(StringData key) {
        this.key = key;
    }

    public StringData getLocalization() {
        return localization;
    }

    public void setLocalization(StringData localization) {
        this.localization = localization;
    }

    public FloatData getValue() {
        return value;
    }

    public void setValue(FloatData value) {
        this.value = value;
    }

    public LongData getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(LongData sampleCount) {
        this.sampleCount = sampleCount;
    }
}
