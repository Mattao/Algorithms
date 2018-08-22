package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/8/22.
 * <p>
 * Write a version of BinarySearch and traces the method calls.
 * Each time the recursive method is called,
 * print the argument values lo and hi, indented by the depth of the recursion.
 * Hint: Add an argument to the recursive method that keeps track of the depth.
 */
public class Ex_1_1_22 {

    public static int rank(int target, int[] a) {
        return rank(target, a, 0, a.length - 1, 0);
    }

    public static int rank(int target, int[] a, int low, int high, int depth) {
        for (int i = 0; i < depth; i++) {
            StdOut.print(" ");
        }
        StdOut.printf("low = %d, high = %d\n", low, high);

        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (target < a[mid]) {
            return rank(target, a, low, mid - 1, depth + 1);
        } else if (target > a[mid]) {
            return rank(target, a, mid + 1, high, depth + 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};
        int key = 5;
        int pos = rank(key, a);
        if (pos == -1) {
            StdOut.print("not found!");
        } else {
            StdOut.printf("position = %d" + pos);
        }
    }
}
