package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LongData;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class EnvoyDatableRelation extends DatableRelation {

    private LongData envoy;

    public EnvoyDatableRelation() {
    }

    public EnvoyDatableRelation(String content) {
        parse(content);
    }

    public LongData getEnvoy() {
        return envoy;
    }

    public void setEnvoy(LongData envoy) {
        this.envoy = envoy;
    }

    @Override
    public void parse(String content) {
        super.parse(content);
        this.envoy = ParseUtils.parseLongData(content, "envoy");
    }
}
