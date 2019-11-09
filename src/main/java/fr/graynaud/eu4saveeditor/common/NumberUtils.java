package fr.graynaud.eu4saveeditor.common;

import java.util.Locale;

public final class NumberUtils {

    private NumberUtils() {
    }

    public static String prettyFloat(Double aDouble) {
        return String.format(Locale.ENGLISH, "%.3f", aDouble);
    }
}
