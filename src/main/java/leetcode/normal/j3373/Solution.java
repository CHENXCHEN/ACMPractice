package leetcode.normal.j3373;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/description/">3373. 连接两棵树后最大目标节点数目 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1, m = edges2.length + 1;
        int[] color1 = new int[n];
        int[] color2 = new int[m];
        int[] count1 = build(edges1, color1);
        int[] count2 = build(edges2, color2);
        int[] ans = new int[n];
        for (int i  = 0; i < n; i++) {
            ans[i] = count1[color1[i]] + Math.max(count2[0], count2[1]);
        }
        return ans;
    }

    int[] build(int[][] _edges, int[] color) {
        int n = _edges.length + 1;
        List<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] e : _edges) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        int[] count = new int[2];
        dfs(0, -1, 0, edges, count, color);
        return count;
    }

    void dfs(int u, int p, int depth, List<Integer>[] edges, int[] count, int[] color) {
        color[u] = depth % 2;
        count[depth % 2]++;
        for (Integer v : edges[u]) {
            if (v == p) continue;
            dfs(v, u, depth + 1, edges, count, color);
        }
    }
}