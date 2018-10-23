package com.matao.sorting;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 8/14/16.
 */
public abstract class BaseSort {
    public abstract void sort(Comparable[] a);

    protected boolean lessThan(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void exchange(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    protected void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (lessThan(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
