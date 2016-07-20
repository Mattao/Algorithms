package Fundamentals;

/**
 * Created by matao on 5/26/16.
 * The implementation of recursion & non-recursion binary search
 * <p>
 * <p>
 * Key Point: <br/>
 * 1. 开闭区间的选择, 本质都是相同的,均表示x在这个区间内, 仅仅影响判断区间只剩唯一元素时的写法<br/>
 * 2. 折半时候向上/向下取整的选择,处理不当会造成死循环
 */
public class BinarySearch {
    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6, 9, 15, 32, 87, 104};
        System.out.println(recursionRank(17, a));
        System.out.println(recursionRank(2, a));
        System.out.println(recursionRank(32, a));

        System.out.println();

        System.out.println(recursionRank1(17, a));
        System.out.println(recursionRank1(2, a));
        System.out.println(recursionRank1(32, a));

        System.out.println();

        System.out.println(rank(17, a));
        System.out.println(rank(2, a));
        System.out.println(rank(32, a));

        System.out.println();

        System.out.println(rank1(17, a));
        System.out.println(rank1(2, a));
        System.out.println(rank1(32, a));

        System.out.println();

        System.out.println(rank2(17, a));
        System.out.println(rank2(2, a));
        System.out.println(rank2(32, a));
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

    public static int recursionRank1(int target, int[] array) {
        return recursionRank1(target, array, 0, array.length - 1);
    }

    // x 必然存在于区间 [low, high] 内。(这里使用闭区间表示)
    public static int recursionRank1(int target, int[] array, int low, int high) {
        if ((high - low + 1) > 1) {
            int mid = low + (high - low + 1) / 2;
            if (target < array[mid]) {
                return recursionRank1(target, array, low, mid - 1);
            } else {
                return recursionRank1(target, array, mid, high);
            }
        }

        if (array[low] != target)
            return -1;
        return low;
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

    /**
     * x 必然存在于区间 [0,n-1] 内。(这里使用闭区间表示)
     *
     * @param target
     * @param array
     * @return
     */
    public static int rank1(int target, int[] array) {
        int low = 0, high = array.length - 1;
        while ((high - low + 1) > 1) {   // 闭区间[low, high]共包含high - low + 1个元素, 只要区间包含的值数量大于1，就继续细分这个区间
            int mid = low + (high - low + 1) / 2;   // 向上取整
            if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        if (array[low] != target)
            return -1;

        return low;
    }

    /**
     * x 必然存在于区间 [0,n) 内。(这里使用开区间表示)
     *
     * @param target
     * @param array
     * @return
     */
    public static int rank2(int target, int[] array) {
        int low = 0, high = array.length;
        while ((high - low) > 1) {  // 开区间[low, high)中共有 high - low 个元素
            int mid = low + (high - low) / 2;
            if (target < array[mid]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (target != array[low]) {
            return -1;
        }
        return low;
    }
}
