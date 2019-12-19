package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Combat extends Eu4Object {

    private List<SiegeCombat> siegeCombats;

    private List<LandCombat> landCombats;

    private List<NavalCombat> navalCombats;

    public Combat() {
    }

    public Combat(String content) {
        parse(content);
    }

    public List<SiegeCombat> getSiegeCombats() {
        return siegeCombats;
    }

    public void setSiegeCombats(List<SiegeCombat> siegeCombats) {
        this.siegeCombats = siegeCombats;
    }

    public List<LandCombat> getLandCombats() {
        return landCombats;
    }

    public void setLandCombats(List<LandCombat> landCombats) {
        this.landCombats = landCombats;
    }

    public List<NavalCombat> getNavalCombats() {
        return navalCombats;
    }

    public void setNavalCombats(List<NavalCombat> navalCombats) {
        this.navalCombats = navalCombats;
    }

    @Override
    public void parse(String content) {
        content = ParseUtils.getNextObject(content, content.indexOf("\ncombat={"));
        this.siegeCombats = ParseUtils.getListSameObject(content, "siege_combat").stream().map(SiegeCombat::new).collect(Collectors.toList());
        this.landCombats = ParseUtils.getListSameObject(content, "land_combat").stream().map(LandCombat::new).collect(Collectors.toList());
        this.navalCombats = ParseUtils.getListSameObject(content, "naval_combat").stream().map(NavalCombat::new).collect(Collectors.toList());
    }
}
