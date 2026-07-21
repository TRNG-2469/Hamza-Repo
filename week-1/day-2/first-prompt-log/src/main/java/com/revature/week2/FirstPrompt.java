package com.revature.week2;

public class FirstPrompt {

    /**
     * Checks if the given String is a valid palindrome.
     * Removes all non-alphanumeric characters and ignores case.
     *
     * @param str the String to check
     * @return true if the String is a palindrome, false otherwise
     */
    public static boolean isValidPalindrome(String str) {
        if (str == null) {
            return false;
        }

        // Build cleaned string by iterating through characters
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        // Check palindrome using two-pointer approach
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

    public static void main(String[] args) {
        System.out.println("=== Palindrome Validation Test Cases ===\n");

        // Test case 1: Null input
        testPalindrome(null, false, "Null input");

        // Test case 2: Empty string
        testPalindrome("", true, "Empty string");

        // Test case 3: Single character
        testPalindrome("a", true, "Single character");

        // Test case 4: Simple palindrome
        testPalindrome("racecar", true, "Simple palindrome (racecar)");

        // Test case 5: Simple non-palindrome
        testPalindrome("hello", false, "Non-palindrome (hello)");

        // Test case 6: Palindrome with mixed case
        testPalindrome("Racecar", true, "Palindrome with mixed case (Racecar)");

        // Test case 7: Palindrome with spaces and punctuation
        testPalindrome("A man, a plan, a canal: Panama", true, "Complex palindrome with spaces and punctuation");

        // Test case 8: Palindrome with numbers
        testPalindrome("12321", true, "Palindrome with numbers (12321)");

        // Test case 9: Mixed alphanumeric palindrome
        testPalindrome("A1b1A", true, "Mixed case and digits (A1b1A)");

        // Test case 10: Non-palindrome with special characters
        testPalindrome("race a car", false, "Non-palindrome with spaces (race a car)");

        // Test case 11: Spaces only
        testPalindrome("   ", true, "Spaces only");

        // Test case 12: Special characters only
        testPalindrome("!@#$%", true, "Special characters only");

        // Test case 13: Long palindrome
        testPalindrome("Was it a car or a cat I saw?", true, "Long palindrome with punctuation");

        // Test case 14: Almost palindrome
        testPalindrome("Madam, I'm Adam", false, "Almost palindrome (slight variation)");
    }

    /**
     * Helper method to test and display palindrome validation results.
     *
     * @param input the String to test
     * @param expected the expected result
     * @param description the test description
     */
    private static void testPalindrome(String input, boolean expected, String description) {
        boolean result = isValidPalindrome(input);
        String status = result == expected ? "✓ PASS" : "✗ FAIL";
        System.out.printf("%s | %s%n", status, description);
        System.out.printf("   Input: %s%n", input == null ? "null" : "\"" + input + "\"");
        System.out.printf("   Expected: %b, Got: %b%n%n", expected, result);
    }

}
