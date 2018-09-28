package com.matao.fundamentals.exercises;

/**
 * Created by matao on 2018/9/28.
 * <p>
 * A string s is a circular rotation of a string t if it matches
 * when the characters are circularly shifted by any number of positions;
 * e.g., ACTGACG is a circular shift of TGACGAC, and vice versa.
 * <p>
 * Detecting this condition is important in the study of genomic sequences.
 * Write a program that checks whether two given strings s and t are circular shifts of one another.
 * Hint: The solution is a one-liner with indexOf(), length(), and string concatenation.
 */
public class Ex_1_2_06 {

    public static void main(String[] args) {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";
        System.out.println(isCircularShifts(s1, s2));

        s1 ="matao";
        s2 ="taoma";
        System.out.println(isCircularShifts(s1, s2));

        s1 ="matao";
        s2 ="taoam";
        System.out.println(isCircularShifts(s1, s2));
    }

    public static boolean isCircularShifts(String s1, String s2) {
        if (s1.length() == s2.length() && s1.concat(s1).indexOf(s2) >= 0) {
            return true;
        }
        return false;
    }
}
