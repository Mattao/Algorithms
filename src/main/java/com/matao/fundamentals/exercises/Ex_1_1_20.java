package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/8/22.
 * <p>
 * Write a recursive static method that computes the value of ln(N!)
 */
public class Ex_1_1_20 {

    // ln(N!) == ln(N * (N-1)!) == lnN + ln((N-1)!)
    public static double lnFactorial(int N) {
        if (N == 0) {
            return 0;
        }
        return Math.log(N) + lnFactorial(N - 1);
    }

    public static void main(String[] args) {
        StdOut.println(lnFactorial(3));
    }
}
