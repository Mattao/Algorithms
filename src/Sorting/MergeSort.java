package Sorting;

import java.util.Arrays;

/**
 * Created by matao on 8/14/16.
 */
public class MergeSort extends BaseSort {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int low, int high) {
        if (high <= low) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        Comparable[] auxiliary = Arrays.copyOf(a, a.length);
        int i = low, j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (lessThan(auxiliary[i], auxiliary[j])) {
                a[k++] = auxiliary[i++];
            } else {
                a[k++] = auxiliary[j++];
            }
        }

        while (i <= mid) {
            a[k++] = auxiliary[i++];
        }

        while (j <= high) {
            a[k++] = auxiliary[j++];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        Integer[] a = {2, 1, 5, 7, 0, 10};
        mergeSort.sort(a);
        System.out.println(Arrays.toString(a));

        Integer[] b = {1, 1, 0, 3, -1};
        mergeSort.sort(b);
        System.out.println(Arrays.toString(b));
    }
}
