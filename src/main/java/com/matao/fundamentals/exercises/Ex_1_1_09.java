package com.matao.fundamentals.exercises;

/**
 * Created by matao on 2018/8/21.
 * <p>
 * Write a code fragment that puts the binary representation of a positive integer N into a String s.
 * <p>
 * Solution: Java has a built-in method Integer.toBinaryString(N) for this job,
 * but the point of the exercise is to see how such a method might be implemented.
 */
public class Ex_1_1_09 {

    public static void main(String[] args) {
        int N = 100;
        System.out.println(Integer.toBinaryString(N));
        System.out.println(toBinaryString(N));
        System.out.println(Integer.toBinaryString(N).equals(toBinaryString(N)));
    }

    public static String toBinaryString(int number) {
        String result = "";
        while (number != 0) {
            int remainder = number % 2;
            int quotient = number / 2;
            result = remainder + result;
            number = quotient;
        }
        return result;
    }
}
