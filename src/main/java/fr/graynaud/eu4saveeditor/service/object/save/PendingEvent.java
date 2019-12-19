package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.BoolData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class PendingEvent extends Eu4Object {

    private String key;

    private TagData country;

    private BoolData scopeIsValid;

    private LongData seed;

    private LongData random;

    private List<SavedEventTarget> savedEventTarget;

    public PendingEvent() {
    }

    public PendingEvent(String content) {
        parse(content);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public TagData getCountry() {
        return country;
    }

    public void setCountry(TagData country) {
        this.country = country;
    }

    public BoolData getScopeIsValid() {
        return scopeIsValid;
    }

    public void setScopeIsValid(BoolData scopeIsValid) {
        this.scopeIsValid = scopeIsValid;
    }

    public LongData getSeed() {
        return seed;
    }

    public void setSeed(LongData seed) {
        this.seed = seed;
    }

    public LongData getRandom() {
        return random;
    }

    public void setRandom(LongData random) {
        this.random = random;
    }

    public List<SavedEventTarget> getSavedEventTarget() {
        return savedEventTarget;
    }

    public void setSavedEventTarget(List<SavedEventTarget> savedEventTarget) {
        this.savedEventTarget = savedEventTarget;
    }

    @Override
    public void parse(String content) {
        this.key = ParseUtils.formatStringValue(content.substring(0, content.indexOf("=")));
        this.country = ParseUtils.parseTagData(content, "country");
        this.scopeIsValid = ParseUtils.parseBoolData(content, "scope_is_valid");
        this.seed = ParseUtils.parseLongData(content, "seed");
        this.random = ParseUtils.parseLongData(content, "random");

        List<String> savedEvents = ParseUtils.getListObject(content, "saved_event_target");
        if (savedEvents != null && !savedEvents.isEmpty()) {
            this.savedEventTarget = savedEvents.stream()
                                               .filter(Objects::nonNull)
                                               .map(SavedEventTarget::new)
                                               .collect(Collectors.toList());
        }
    }
}
