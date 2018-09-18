package com.matao.fundamentals.exercises;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 2018/8/22.
 * <p>
 * Equal keys.
 * Add to BinarySearch a static method rank() that takes a key
 * and a sorted array of int values (some of which may be equal) as arguments
 * and returns the number of elements that are smaller than the key
 * and a similar method count() that returns the number of elements equal to the key.
 * <p>
 * Note: If i and j are the values returned by rank(key, a) and count(key, a) respectively,
 * then a[i..i+j-1] are the values in the array that are equal to key.
 */
public class Ex_1_1_29 {

    // Note: find the last element smaller than the key
    public static int rank(int key, int[] array) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                // If key equals array[mid], check if duplicates are present.
                // And find the position of first element.
                while (mid >= 0 && key == array[mid]) {
                    mid--;
                }
                return mid + 1;

            }
        }
        if (array[low] < key) {
            return low + 1;
        } else {
            return low;
        }
    }

    public static int count(int key, int[] array) {
        int firstPosSmallerThan = rank(key, array) - 1;
        int count = 0;
        for (int i = firstPosSmallerThan + 1; i < array.length && array[i] == key; i++) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] whitelist = {1, 1, 5, 5, 5, 7, 7, 7, 9};

        int key = 7;
        StdOut.printf("The count smaller than %d: %d\n", key, rank(key, whitelist));
        StdOut.printf("The count equals %d: %d\n", key, count(key, whitelist));

        key = 6;
        StdOut.printf("The count smaller than %d: %d\n", key, rank(key, whitelist));
        StdOut.printf("The count equals %d: %d\n", key, count(key, whitelist));

        key = 1;
        StdOut.printf("The count smaller than %d: %d\n", key, rank(key, whitelist));
        StdOut.printf("The count equals %d: %d\n", key, count(key, whitelist));

        key = 8;
        StdOut.printf("The count smaller than %d: %d\n", key, rank(key, whitelist));
        StdOut.printf("The count equals %d: %d\n", key, count(key, whitelist));
    }
}
