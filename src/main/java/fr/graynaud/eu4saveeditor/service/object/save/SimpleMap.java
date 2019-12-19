package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_EMPTY)
public abstract class SimpleMap<T> extends Eu4Object {

    public SimpleMap() {
    }

    public SimpleMap(String content) {
        super(content);
    }

    public abstract Map<String, T> getMap();
}
