package com.matao.sorting;

import java.util.Arrays;

/**
 * Created by matao on 8/14/16.
 */
public class InsertionSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && lessThan(a[j], a[j - 1]); j--) {
                exchange(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();

        Integer[] a = {2, 1, 5, 7, 0, 10};
        insertionSort.sort(a);
        System.out.println(Arrays.toString(a));

        Integer[] b = {1, 1, 0, 3, -1};
        insertionSort.sort(b);
        System.out.println(Arrays.toString(b));
    }
}
