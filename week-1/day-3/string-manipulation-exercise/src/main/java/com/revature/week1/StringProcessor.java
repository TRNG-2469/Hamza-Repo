package com.revature.week1;

public class StringProcessor {
    public static String reverse(String input){
        char[] chars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            chars[input.length() - 1 - i] = input.charAt(i);
        }
        return new String(chars);
    }
    public static int countVowels(String input){
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }
        return count;
    }
    public static boolean isPalindrome(String input){
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
