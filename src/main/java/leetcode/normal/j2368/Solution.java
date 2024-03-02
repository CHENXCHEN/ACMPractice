package leetcode.normal.j2368;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reachable-nodes-with-restrictions/description/">2368. 受限条件下可到达节点的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean[] reject;
    ArrayList<Integer>[] edges;

    public int reachableNodes(int n, int[][] _edges, int[] restricted) {
        reject = new boolean[n];
        for (int rej : restricted) {
            reject[rej] = true;
        }
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] edge : _edges) {
            edges[edge[0]].add(edge[1]);
            edges[edge[1]].add(edge[0]);
        }
        return solve(0, -1);
    }

    int solve(int cur, int parent) {
        if (reject[cur]) return 0;
        int res = 1;
        for (Integer to : edges[cur]) {
            if (to == parent) continue;
            res += solve(to, cur);
        }
        return res;
    }
}