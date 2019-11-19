package fr.graynaud.eu4saveeditor.service.object.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

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
            gen.writeStringField(value.getKey(), value.getValue() == null ? "1.1.1" : DATE_TIME_FORMATTER.format(((DateData) value).getValue()));
        } else if (value instanceof NotParsedData) {
            //Do nothing
        } else {
            gen.writeObjectField(value.getKey(), value.getValue());
        }
    }

    @Override
    public void serializeWithType(AbstractData value, JsonGenerator gen, SerializerProvider provider,
                                  TypeSerializer typeSer) throws IOException {
        serialize(value, gen, provider);
    }
}
