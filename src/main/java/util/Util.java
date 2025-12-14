package util;

/**
 * Converts each word in a string to title case. Assume words in str are always
 * separated by space, such as Yi Wang, Computer Science And Math. str.split() method
 * will be used. All studentName, departmentName, courseName stored in a class needs
 * to be in title case.
 */
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