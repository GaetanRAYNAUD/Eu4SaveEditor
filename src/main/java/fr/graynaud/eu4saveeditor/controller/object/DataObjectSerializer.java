package fr.graynaud.eu4saveeditor.controller.object;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.io.IOException;

public class DataObjectSerializer extends JsonSerializer<DataObject> {

    @Override
    public void serialize(DataObject value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("fileName", value.getFileName());
        gen.writeObjectFieldStart("meta");

        for (AbstractData data : value.getMeta()) {
            gen.writeObjectField(data.getKey(), data);
        }

        gen.writeEndObject();
        gen.writeObjectFieldStart("gamestate");

        for (AbstractData data : value.getGamestate()) {
            gen.writeObjectField(data.getKey(), data);
        }

        gen.writeEndObject();
        gen.writeObjectFieldStart("ai");

        for (AbstractData data : value.getAi()) {
            gen.writeObjectField(data.getKey(), data);
        }

        gen.writeEndObject();
        gen.writeEndObject();
    }
}
