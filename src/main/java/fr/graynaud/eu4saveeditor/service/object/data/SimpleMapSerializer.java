package fr.graynaud.eu4saveeditor.service.object.data;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import fr.graynaud.eu4saveeditor.service.object.save.SimpleMap;

import java.io.IOException;

public class SimpleMapSerializer extends JsonSerializer<SimpleMap<?>> {

    @Override
    public void serialize(SimpleMap<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getMap());
    }
}
