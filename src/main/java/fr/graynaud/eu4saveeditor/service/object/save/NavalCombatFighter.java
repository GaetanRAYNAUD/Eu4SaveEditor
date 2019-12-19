package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.DoubleData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NavalCombatFighter extends CombatFighter {

    private DoubleData lightShip;

    private DoubleData heavyShip;

    private DoubleData transport;

    public NavalCombatFighter() {
    }

    public NavalCombatFighter(String content) {
        parse(content);
    }

    public DoubleData getLightShip() {
        return lightShip;
    }

    public void setLightShip(DoubleData lightShip) {
        this.lightShip = lightShip;
    }

    public DoubleData getHeavyShip() {
        return heavyShip;
    }

    public void setHeavyShip(DoubleData heavyShip) {
        this.heavyShip = heavyShip;
    }

    public DoubleData getTransport() {
        return transport;
    }

    public void setTransport(DoubleData transport) {
        this.transport = transport;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.lightShip = ParseUtils.parseDoubleData(content, "light_ship");
        this.heavyShip = ParseUtils.parseDoubleData(content, "heavy_ship");
        this.transport = ParseUtils.parseDoubleData(content, "transport");
    }
}
