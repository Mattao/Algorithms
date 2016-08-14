package Sorting;

/**
 * Created by matao on 8/13/16.
 * 选择排序法:
 * 对于长度为N的数组,选择排序需要大约 pow(N, 2)/2 的比较
 * 以及 N 次交换
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

    }
}
