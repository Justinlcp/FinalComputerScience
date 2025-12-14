package util;

public class Util {
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String result = "";

        for (String word : words) {
            if (word.length() > 0) {
                result += word.substring(0, 1).toUpperCase()
                        + word.substring(1).toLowerCase()
                        + " ";
            }
        }

        return result.trim();
    }
}