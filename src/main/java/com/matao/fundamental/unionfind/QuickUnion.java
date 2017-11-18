package com.matao.fundamental.unionfind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 8/14/16.
 */
public class QuickUnion {
    private int[] id;   // id[]指向下一个连接的触点
    private int N;      // 分量数量

    public QuickUnion(int count) {
        N = count;
        id = new int[N];
        // 初始化count个触点, id值指向同一个分量中的另一个触点(也可能是自己),即链接至下一个点
        // 初始化时均指向自己
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * @return 连通分量的数量
     * 一开始有N个连通分量,
     * 将两个分量合并的每次union操作都会使分量数减一
     */
    public int count() {
        return N;
    }

    /**
     * @param p
     * @param q
     * @return p和q是否存在于同一个连通分量中
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @param p
     * @return 从p点开始寻找根触点, 即连接指向自己的点
     */
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    /**
     * 将p和q的根节点统一
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        id[pRoot] = qRoot;
        N--;
    }

    public static void main(String[] args) {
        // e.g. (4, 3)(3, 8)(6, 5)(9, 4)(2, 1)(8, 9)(5,0)(7,2)(6,1)(1,0)(6,7)
        // (8, 9)(1, 0)(6, 7)这三对将不会被输出
        int n = 10;
        QuickUnion uf = new QuickUnion(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        StdOut.println("count: " + uf.count());
    }
}
