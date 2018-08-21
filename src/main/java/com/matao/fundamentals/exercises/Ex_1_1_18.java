package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/8/21.
 * <p>
 * What are the values of mystery(2, 25) and mystery(3, 11)?
 * Given positive integers a and b, describe what value mystery(a, b) computes. Answer the same question,
 * but replace the three + operators with * and replace return 0 with return 1.
 * <p><br>
 * result: mystery1(a, b) == a * b; mystery2(a, b) == Math.pow(a, b)
 */
public class Ex_1_1_18 {
    public static int mystery1(int a, int b) {
        StdOut.printf("%7d, %3d\n", a, b);

        if (b == 0) {
            return 0;
        }

        if (b % 2 == 0) {
            return mystery1(a + a, b / 2);
        }

        return mystery1(a + a, b / 2) + a;
    }

    public static int mystery2(int a, int b) {
        StdOut.printf("%7d, %3d\n", a, b);
        if (b == 0) {
            return 1;
        }

        if (b % 2 == 0) {
            return mystery2(a * a, b / 2);
        }

        return mystery2(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        StdOut.println("result: " + mystery1(2, 25));
        StdOut.println("result: " + mystery1(3, 11));
        StdOut.println(mystery1(3, 11) == 3 * 11);

        StdOut.println();

        StdOut.println("result: " + mystery2(2, 25));
        StdOut.println("result: " + mystery2(3, 11));
        StdOut.println(mystery2(3, 11) == Math.pow(3, 11));
    }
}
