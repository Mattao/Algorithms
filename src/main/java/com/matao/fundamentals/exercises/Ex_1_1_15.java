package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by matao on 2018/8/21.
 * <p>
 * Write a static method histogram() that takes an array a[] of int values and an integer M as arguments
 * and returns an array of length M whose i-th entry is the number of times the integer i appeared in the argument array.
 * If the values in a[] are all between 0 and M−1, the sum of the values in the returned array should be equal to a.length.
 */
public class Ex_1_1_15 {

    public static void main(String[] args) {
        int N = 30;
        int M = 10;

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(M);
        }

        for (int i = 0; i < N; i++) {
            StdOut.printf("%2d", a[i]);
        }

        int[] h = histogram(a, M);

        StdOut.println("\n");
        for (int i = 0; i < M; i++) {
            StdOut.printf("%2d", h[i]);
        }
    }

    public static int[] histogram(int[] a, int M) {
        int[] h = new int[M];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < M) {
                h[a[i]]++;
            }
        }
        return h;
    }
}
