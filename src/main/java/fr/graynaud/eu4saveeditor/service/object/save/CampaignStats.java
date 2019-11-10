package fr.graynaud.eu4saveeditor.service.object.save;

import fr.graynaud.eu4saveeditor.service.object.data.FloatData;
import fr.graynaud.eu4saveeditor.service.object.data.IntData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

public class CampaignStats {

    private IntData id;

    private IntData comparison;

    private StringData key;

    private StringData localization;

    private FloatData value;

    private IntData sampleCount;

    public IntData getId() {
        return id;
    }

    public void setId(IntData id) {
        this.id = id;
    }

    public IntData getComparison() {
        return comparison;
    }

    public void setComparison(IntData comparison) {
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

    public IntData getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(IntData sampleCount) {
        this.sampleCount = sampleCount;
    }
}
