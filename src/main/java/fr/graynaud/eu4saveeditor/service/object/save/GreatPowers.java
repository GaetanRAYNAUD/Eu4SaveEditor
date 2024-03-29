package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GreatPowers extends Eu4Object {

    private List<GreatPowerOriginal> original;

    public GreatPowers() {
    }

    public GreatPowers(String content) {
        super(content);
    }

    public List<GreatPowerOriginal> getOriginal() {
        return original;
    }

    public void setOriginal(List<GreatPowerOriginal> original) {
        this.original = original;
    }

    @Override
    public void parse(String content) {
        String subContent = ParseUtils.getNextObject(content, content.indexOf("great_powers={"));
        List<String> originals = ParseUtils.getListSameObject(subContent, "original");

        if (originals != null && !originals.isEmpty()) {
            this.original = originals.stream().filter(Objects::nonNull).map(s -> {
                GreatPowerOriginal original = new GreatPowerOriginal();
                original.parse(s);
                return original;
            }).collect(Collectors.toList());
        }
    }
}
