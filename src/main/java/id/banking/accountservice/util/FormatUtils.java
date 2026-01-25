package id.banking.accountservice.util;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Component
public class FormatUtils {

    // masking after 5 digits from the front and 4 digits from behind
    public static String formatAccountNumberMasked(String raw) {
        if (raw == null) return "";
        String digits = raw.replaceAll("\\D+", "");
        int n = digits.length();
        if (n == 0) return "";

        StringBuilder masked = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char character = digits.charAt(i);
            masked.append(i < 5 || i >= n - 4 ? character : '*');
        }

        StringBuilder grouped = new StringBuilder(masked.length() + masked.length() / 4);
        for (int i = 0; i < masked.length(); i++) {
            if (i > 0 && i % 4 == 0) grouped.append(' ');
            grouped.append(masked.charAt(i));
        }
        return grouped.toString();
    }

    public static String formatAccountNumberUsingSpace(String accountNumber) {
        StringBuilder grouped = new StringBuilder(accountNumber.length() + accountNumber.length() / 4);
        for (int i = 0; i < accountNumber.length(); i++) {
            if (i > 0 && i % 4 == 0) grouped.append(' ');
            grouped.append(accountNumber.charAt(i));
        }
        return grouped.toString();
    }

    public static String cleanLongWhitespace(String stringToTrim) {
        return stringToTrim.replaceAll("\\s+", " ");
    }

    public static String formatAmount(BigDecimal amount, String pattern) {
        if (amount == null || pattern == null || pattern.trim().length()==0) {
            return "";
        }

        Locale currentLocale = Locale.getDefault();
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(currentLocale);
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        DecimalFormat df = new DecimalFormat(pattern, otherSymbols);
        return df.format(amount);
    }
}
