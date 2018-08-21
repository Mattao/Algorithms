package com.matao.fundamentals;

import java.util.Objects;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (Objects.isNull(s)) return false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("matao"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(" m_m_m "));
    }
}
