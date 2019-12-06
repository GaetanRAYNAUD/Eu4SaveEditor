package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;
import fr.graynaud.eu4saveeditor.service.object.data.ProvinceIdData;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class AutoFleetTransport implements Parsable {

    private ProvinceIdData target;

    private List<IdType> autoTransferNavies;

    public AutoFleetTransport() {
    }

    public AutoFleetTransport(String content) {
        parse(content);
    }

    public ProvinceIdData getTarget() {
        return target;
    }

    public void setTarget(ProvinceIdData target) {
        this.target = target;
    }

    public List<IdType> getAutoTransferNavies() {
        return autoTransferNavies;
    }

    public void setAutoTransferNavies(List<IdType> autoTransferNavies) {
        this.autoTransferNavies = autoTransferNavies;
    }

    @Override
    public void parse(String content) {
        int index = content.indexOf("auto_fleet_transport");

        if (index >= 0) {
            content = ParseUtils.getNextObject(content, index + 1);
            this.target = ParseUtils.parseProvinceIdData(content, "target");
            this.autoTransferNavies = ParseUtils.getListSameObject(content, "auto_transfer_navy")
                                                .stream()
                                                .map(IdType::new)
                                                .collect(Collectors.toList());
        }
    }
}
