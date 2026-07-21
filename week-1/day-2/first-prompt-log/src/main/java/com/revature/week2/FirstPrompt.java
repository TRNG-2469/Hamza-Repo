package com.revature.week2;

public class FirstPrompt {

    /**
     * Checks if a given String is a valid palindrome.
     * Ignores spaces, punctuation, and case sensitivity.
     * Only alphanumeric characters are considered.
     *
     * @param s the String to check
     * @return true if the string is a valid palindrome, false otherwise
     */
    public static boolean isValidPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Checks if a given String is a palindrome.
     * Removes all non-alphanumeric characters and ignores character casing.
     * Uses simple character iteration with no advanced streams.
     *
     * @param s the String to check
     * @return false if null, true if the string is a palindrome after filtering
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
