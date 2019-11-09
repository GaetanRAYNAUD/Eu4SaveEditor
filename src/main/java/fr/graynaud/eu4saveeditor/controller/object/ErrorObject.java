package fr.graynaud.eu4saveeditor.controller.object;

public class ErrorObject {

    private final ErrorCode message;

    public ErrorObject(ErrorCode message) {
        this.message = message;
    }

    public ErrorCode getMessage() {
        return message;
    }
}
