package Basics;

/**
 * Created by matao on 5/26/16.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6, 9, 15, 32, 87, 104};
        System.out.println(rank(17, a));
        System.out.println(rank(2, a));
        System.out.println(rank(32, a));
    }

    public static int rank(int target, int[] array) {
        return rank(target, array, 0, array.length - 1);
    }

    public static int rank(int target, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (target < array[mid]) {
            return rank(target, array, low, mid - 1);
        } else if (target > array[mid]) {
            return rank(target, array, mid + 1, high);
        } else {
            return mid;
        }
    }
}
