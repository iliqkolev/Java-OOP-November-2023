package bank.common;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean NullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }
}
