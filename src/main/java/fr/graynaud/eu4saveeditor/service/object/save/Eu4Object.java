package fr.graynaud.eu4saveeditor.service.object.save;

public abstract class Eu4Object {

    public Eu4Object() {
    }

    Eu4Object(String content) {
        parse(content);
    }

    public abstract void parse(String content);
}
