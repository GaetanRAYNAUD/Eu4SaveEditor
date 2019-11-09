package fr.graynaud.eu4saveeditor.common;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public final class Constants {
    private Constants() {
    }

    public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy.M.d");
    public static final List<String> FILES_NAME = Arrays.asList("meta", "gamestate", "ai");
    public static final String STARTING_TEXT = "EU4txt";
}
