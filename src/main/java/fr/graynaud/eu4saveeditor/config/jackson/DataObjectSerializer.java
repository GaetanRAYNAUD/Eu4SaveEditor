package fr.graynaud.eu4saveeditor.config.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import fr.graynaud.eu4saveeditor.controller.object.DataObject;
import fr.graynaud.eu4saveeditor.service.object.data.AbstractData;

import java.io.IOException;

public class DataObjectSerializer extends JsonSerializer<DataObject> {

    @Override
    public void serialize(DataObject value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectFieldStart("gamestate");

        for (AbstractData data : value.getGamestate()) {
            gen.writeObject(data);
        }

        gen.writeEndObject();
        gen.writeEndObject();
    }

    @Override
    public boolean isEmpty(SerializerProvider provider, DataObject value) {
        return super.isEmpty(provider, value);
    }
}
