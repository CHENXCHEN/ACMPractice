package leetcode.normal.j3372;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/description/">3372. 连接两棵树后最大目标节点数目 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1, m = edges2.length + 1;
        // 算出第一棵树中，每个节点 <= k 的目标节点数
        int[] count1 = build(edges1, k);
        // 算出第二棵树中，每个节点 <= k-1 的目标节点数
        int[] count2 = build(edges2, k - 1);
        // 算出第二颗树中 <= k-1 的目标节点数，这个节点与第一棵树的每一个节点最大
        int maxCount2 = 0;
        for (int c : count2) {
            maxCount2 = Math.max(maxCount2, c);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + maxCount2;
        }
        return res;
    }

    int[] build(int[][] _edges, int k) {
        int n = _edges.length + 1;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] e : _edges) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, edges, k);
        }
        return res;
    }

    int dfs(int u, int p, ArrayList<Integer>[] edges, int k) {
        if (k < 0) return 0;
        int res = 1;
        for (Integer v : edges[u]) {
            if (v == p) continue;
            res += dfs(v, u, edges, k - 1);
        }
        return res;
    }
}