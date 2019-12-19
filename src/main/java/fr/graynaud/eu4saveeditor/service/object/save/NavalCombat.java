package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NavalCombat extends PendingCombat<NavalCombatFighter> {

    public NavalCombat() {
        super(NavalCombatFighter::new);
    }

    public NavalCombat(String content) {
        super(NavalCombatFighter::new);
        parse(content);
    }
}
