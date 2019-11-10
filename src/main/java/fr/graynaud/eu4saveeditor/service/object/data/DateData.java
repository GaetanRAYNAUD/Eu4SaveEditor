package fr.graynaud.eu4saveeditor.service.object.data;

import fr.graynaud.eu4saveeditor.common.Constants;

import java.time.LocalDate;

public class DateData extends AbstractData<LocalDate> {

    public DateData(String key, LocalDate value) {
        super(DataType.DATE, key, value);
    }

    @Override
    public String toSave(Integer indent) {
        return "\t".repeat(indent) + this.key + "=" + this.value.format(Constants.DATE_FORMAT) + "\n";
    }

    @Override
    public Boolean isValueValid() {
        return this.value != null;
    }
}
