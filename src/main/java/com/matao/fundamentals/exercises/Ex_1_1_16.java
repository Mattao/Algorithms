package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/8/21.
 * <p>
 * Give the value of exR1(6)
 * 311361142246
 */
public class Ex_1_1_16 {
    public static String exR1(int n) {
        if (n <= 0) return "";
        return exR1(n - 3) + n + exR1(n - 2) + n;
    }

    public static void main(String[] args) {
        StdOut.println(exR1(6));
        // 311361142246
    }
}
