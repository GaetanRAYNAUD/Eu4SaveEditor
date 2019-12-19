package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;
import fr.graynaud.eu4saveeditor.service.object.data.TagData;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public abstract class Empire extends Eu4Object {

    private TagData emperor;

    private DoubleData imperialInfluence;

    private LongData reformLevel;

    private List<Emperor> oldEmperors;

    public Empire() {
    }

    public Empire(String content) {
        super(content);
    }

    public TagData getEmperor() {
        return emperor;
    }

    public void setEmperor(TagData emperor) {
        this.emperor = emperor;
    }

    public DoubleData getImperialInfluence() {
        return imperialInfluence;
    }

    public void setImperialInfluence(DoubleData imperialInfluence) {
        this.imperialInfluence = imperialInfluence;
    }

    public LongData getReformLevel() {
        return reformLevel;
    }

    public void setReformLevel(LongData reformLevel) {
        this.reformLevel = reformLevel;
    }

    public List<Emperor> getOldEmperors() {
        return oldEmperors;
    }

    public void setOldEmperors(List<Emperor> oldEmperors) {
        this.oldEmperors = oldEmperors;
    }

    @Override
    public void parse(String content) {
        this.emperor = ParseUtils.parseTagData(content, "emperor");
        this.imperialInfluence = ParseUtils.parseDoubleData(content, "imperial_influence");
        this.reformLevel = ParseUtils.parseLongData(content, "reform_level");
        this.oldEmperors = ParseUtils.getListSameObject(content, "old_emperor")
                                     .stream()
                                     .map(Emperor::new)
                                     .collect(Collectors.toList());
    }
}
