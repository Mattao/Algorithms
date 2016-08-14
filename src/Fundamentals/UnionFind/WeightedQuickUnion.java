package Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 8/14/16.
 * 思路同QuickUnion
 * 不同于QuickUnion中union总是随意将一棵树连接到另一棵树,
 * 加权方法会总是将较小的树链接到较大的树上
 */
public class WeightedQuickUnion {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnion(int count) {
        this.count = count;
        id = new int[count];
        sz = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        // e.g. (4, 3)(3, 8)(6, 5)(9, 4)(2, 1)(8, 9)(5,0)(7,2)(6,1)(1,0)(6,7)
        // (8, 9)(1, 0)(6, 7)这三对将不会被输出
        int n = 10;
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!weightedQuickUnion.connected(p, q)) {
                weightedQuickUnion.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println("count: " + weightedQuickUnion.count());
    }
}
