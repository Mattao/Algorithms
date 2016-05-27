package Basics;

/**
 * Created by matao on 5/26/16.
 * The implementation of recursion & non-recursion binary search
 */
public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6, 9, 15, 32, 87, 104};
        System.out.println(recursionRank(17, a));
        System.out.println(recursionRank(2, a));
        System.out.println(recursionRank(32, a));

        System.out.println(rank(17, a));
        System.out.println(rank(2, a));
        System.out.println(rank(32, a));
    }

    public static int recursionRank(int target, int[] array) {
        return recursionRank(target, array, 0, array.length - 1);
    }

    /**
     * @param target number to search in array
     * @param array  array must be sorted
     * @param low
     * @param high
     * @return
     */
    public static int recursionRank(int target, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (target < array[mid]) {
            return recursionRank(target, array, low, mid - 1);
        } else if (target > array[mid]) {
            return recursionRank(target, array, mid + 1, high);
        } else {
            return mid;
        }
    }

    public static int rank(int target, int[] array) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
