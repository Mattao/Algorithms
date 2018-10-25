package com.matao.sorting;

import java.util.Arrays;

/**
 * Created by matao on 8/14/16.
 *
 * <pre>
 *     Shell Sort
 *
 * ShellSort is a simple extension of insertion sort that gains speed by
 * allowing exchanges of array entries that are far apart,
 * to produce partially sorted arrays that can be efficiently sorted, eventually by insertion sort.
 * </pre>
 */
public class ShellSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && lessThan(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        Integer[] a = {2, 1, 5, 7, 0, 10};
        shellSort.sort(a);
        System.out.println(shellSort.isSorted(a));
        System.out.println(Arrays.toString(a));

        Integer[] b = {1, 1, 0, 3, -1};
        shellSort.sort(b);
        System.out.println(shellSort.isSorted(b));
        System.out.println(Arrays.toString(b));
    }
}
