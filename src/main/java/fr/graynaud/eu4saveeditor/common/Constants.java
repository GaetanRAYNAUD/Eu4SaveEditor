package fr.graynaud.eu4saveeditor.common;

import java.time.format.DateTimeFormatter;

public final class Constants {

    private Constants() {
    }

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.M.d");
    public static final String STARTING_TEXT = "EU4txt";
    public static final String DUPLICATION_KEY = "_duplication_";
}
