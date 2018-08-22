package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/8/22.
 * <p>
 * Develop a better implementation of F(N) that saves computed values in an array.
 */
public class Ex_1_1_19 {

    public static long[] F(int N) {
        long[] fibonacci = new long[N + 1];
        if (N == 0) {
            return fibonacci;
        }

        fibonacci[1] = 1;
        if (N == 1) {
            return fibonacci;
        }

        for (int i = 2; i <= N; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }

    public static void main(String[] args) {
        long[] fibonacci = F(50);
        for (int N = 0; N < fibonacci.length; N++) {
            StdOut.println(N + " " + fibonacci[N]);
        }
    }
}
