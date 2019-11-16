package fr.graynaud.eu4saveeditor.common;

import java.math.BigDecimal;
import java.util.Locale;

public final class Utils {

    private Utils() {
    }

    public static String prettyFloat(Double aDouble) {
        int scale = Math.max(3, BigDecimal.valueOf(aDouble).scale());
        return String.format(Locale.ENGLISH, "%." + scale + "f", aDouble);
    }

    public static String formatStringValue(String s) {
        s = s.trim();

        if (s.isEmpty() || s.isBlank()) {
            return null;
        }

        if (hasQuotes(s)) {
            return s.substring(1, s.length() - 1);
        } else {
            return s;
        }
    }

    public static boolean hasQuotes(String s) {
        if (s== null || s.isEmpty()) {
            return false;
        }

        return s.startsWith("\"") && s.endsWith("\"");
    }
}
