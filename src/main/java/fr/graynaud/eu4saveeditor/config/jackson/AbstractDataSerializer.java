package fr.graynaud.eu4saveeditor.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import fr.graynaud.eu4saveeditor.common.Utils;
import fr.graynaud.eu4saveeditor.service.object.data.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class AbstractDataSerializer extends JsonSerializer<AbstractData> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd");

    @Override
    public void serialize(AbstractData value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value instanceof ObjectData) {
            gen.writeObjectFieldStart(value.getKey());

            for (AbstractData data : ((ObjectData) value).getValue()) {
                gen.writeObject(data);
            }

            gen.writeEndObject();
        } else if (value instanceof ListObjectData) {
            gen.writeObjectFieldStart(value.getKey());

            for (AbstractData data : ((ListObjectData) value).getValue()) {
                gen.writeObject(data);
            }

            gen.writeEndObject();
        } else if (value instanceof DateData) {
            gen.writeString(value.getValue() == null ? "1.1.1" : DATE_TIME_FORMATTER.format(((DateData) value).getValue()));
        } else if (value instanceof NotParsedData) {
            //Do nothing
        } else if (value instanceof DoubleData) {
            gen.writeNumber(Utils.prettyDouble(((DoubleData) value).getValue()));
        } else {
            gen.writeObject(value.getValue());
        }
    }

    @Override
    public void serializeWithType(AbstractData value, JsonGenerator gen, SerializerProvider provider,
                                  TypeSerializer typeSer) throws IOException {
        serialize(value, gen, provider);
    }
}
