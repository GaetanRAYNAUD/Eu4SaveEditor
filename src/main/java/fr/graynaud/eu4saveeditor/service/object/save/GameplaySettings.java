package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LineLongData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GameplaySettings extends Eu4Object {

    private LineLongData setGameplayOptions;

    public GameplaySettings() {
    }

    public GameplaySettings(String content) {
        super(content);
    }

    public LineLongData getSetGameplayOptions() {
        return setGameplayOptions;
    }

    public void setSetGameplayOptions(LineLongData setGameplayOptions) {
        this.setGameplayOptions = setGameplayOptions;
    }

    @Override
    public void parse(String content) {
        this.setGameplayOptions = ParseUtils.parseLineLongData(content, "setgameplayoptions");
    }
}
