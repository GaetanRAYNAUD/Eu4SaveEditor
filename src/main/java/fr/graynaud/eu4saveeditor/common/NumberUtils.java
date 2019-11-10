package fr.graynaud.eu4saveeditor.common;

import java.math.BigDecimal;
import java.util.Locale;

public final class NumberUtils {

    private NumberUtils() {
    }

    public static String prettyFloat(Double aDouble) {
        int scale = Math.max(3, BigDecimal.valueOf(aDouble).scale());
        return String.format(Locale.ENGLISH, "%." + scale + "f", aDouble);
    }
}
