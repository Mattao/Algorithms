package com.matao.sorting;

import java.util.Arrays;

/**
 * Created by matao on 8/14/16.
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
