package com.matao.sorting;

import java.util.Arrays;

/**
 * Created by matao on 8/13/16.
 * <pre>
 * Selection Sort
 *
 * 1) Find the smallest item in the array and exchange it with the first entry
 *    (itself if the first entry is already the smallest).
 * 2) Then, find the next smallest item and exchange it with the second entry.
 * 3) Continue in this way until the entire array is sorted.
 *
 * for each i from 0 to N-1, there is 1 exchange, so the totals are N exchanges.
 * and the total compares is (N-1) + (N-2) + ... + 2 + 1 + 0 = N(N-1)/ ~ pow(N, 2)/2 compares.
 * </pre>
 */
public class SelectionSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (lessThan(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exchange(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();

        Integer[] a = {2, 1, 5, 7, 0, 10};
        selectionSort.sort(a);
        System.out.println(selectionSort.isSorted(a));
        System.out.println(Arrays.toString(a));

        Integer[] b = {1, 1, 0, 3, -1};
        selectionSort.sort(b);
        System.out.println(selectionSort.isSorted(b));
        System.out.println(Arrays.toString(b));
    }
}
