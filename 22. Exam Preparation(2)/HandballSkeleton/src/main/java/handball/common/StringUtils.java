package handball.common;

public class StringUtils {
    public static boolean NullOrWhiteSpace(String str){
        return str == null || str.trim().isEmpty();
    }
}
