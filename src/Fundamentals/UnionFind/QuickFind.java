package Fundamentals.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by matao on 8/13/16.
 * 保证当且仅当id[p]==id[q]时p和q是联通的。也就是说同一个连通分量中所有触点在id[]中的值都是相同的。
 * 这意味着connected(p, q)只需判断id[p] == id[q]
 */
public class QuickFind {
    private int[] id;   // 分量id(以触电作为索引)
    private int N;  // 分量数量

    public QuickFind(int count) {
        N = count;
        id = new int[N];
        // 初始化count个触点
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
        return id[p] == id[q];
//        return find(p) == find(q);
    }

    /**
     * @param p
     * @return p所在分量的标示符(0 - N)
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * 在p和q之间添加连接
     * 即将两个集合中所有触点对应的id[]元素的值变成同一值。
     * 将id[p]相等的元素变成id[q], 反之亦可
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
        N--;
    }

    public static void main(String[] args) {
        // e.g. (4, 3)(3, 8)(6, 5)(9, 4)(2, 1)(8, 9)(5,0)(7,2)(6,1)(1,0)(6,7)
        int n = 10;
        QuickFind uf = new QuickFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println("count: " + uf.count());
    }
}
