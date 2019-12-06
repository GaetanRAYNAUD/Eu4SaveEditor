package fr.graynaud.eu4saveeditor.common;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public final class Utils {

    private Utils() {
    }

    public static String prettyDouble(Double aDouble) {
        int scale = Math.max(3, BigDecimal.valueOf(aDouble).scale());
        return String.format(Locale.ENGLISH, "%." + scale + "f", aDouble);
    }

    public static Long nullSafeParseLong(String s) {
        if (s == null) {
            return null;
        }

        return Long.valueOf(s);
    }

    public static Double nullSafeParseDouble(String s) {
        if (s == null) {
            return null;
        }

        return Double.valueOf(s);
    }
    public static LocalDate nullSafeParseLocalDate(String s) {
        if (s == null) {
            return null;
        }

        try {
            return LocalDate.parse(s, Constants.DATE_FORMAT);
        } catch (DateTimeParseException ignored) {
            return null;
        }
    }
}
