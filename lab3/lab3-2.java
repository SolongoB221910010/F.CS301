import java.util.HashSet;

public class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            if (!s.contains(String.valueOf(swapCase(s.charAt(i))))) {
                String left = longestNiceSubstring(s.substring(0, i));
                String right = longestNiceSubstring(s.substring(i + 1));
                return left.length() >= right.length() ? left : right;
            }
        }

        return s;
    }

    private char swapCase(char c) {
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        } else {
            return Character.toLowerCase(c);
        }
    }

    
}
