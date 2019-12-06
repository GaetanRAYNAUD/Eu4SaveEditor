package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.LineLongData;
import fr.graynaud.eu4saveeditor.service.object.data.ProvinceIdData;
import fr.graynaud.eu4saveeditor.service.object.data.StringData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SavedEventTarget implements Parsable {

    private ProvinceIdData province;

    private StringData name;

    public SavedEventTarget() {
    }

    public SavedEventTarget(String content) {
        parse(content);
    }

    public ProvinceIdData getProvince() {
        return province;
    }

    public void setProvince(ProvinceIdData province) {
        this.province = province;
    }

    public StringData getName() {
        return name;
    }

    public void setName(StringData name) {
        this.name = name;
    }

    @Override
    public void parse(String content) {
        this.province = ParseUtils.parseProvinceIdData(content, "province");
        this.name = ParseUtils.parseStringData(content, "name");
    }
}
