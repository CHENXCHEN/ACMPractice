package leetcode.normal.j2065;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-path-quality-of-a-graph/description/">2065. 最大化一张图中的路径价值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<int[]>[] edges;
    int ans;
    boolean[] visit;
    int[] values;

    public int maximalPathQuality(int[] values, int[][] _edges, int maxTime) {
        this.values = values;
        int n = values.length;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] edge : _edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            edges[u].add(new int[]{v, w});
            edges[v].add(new int[]{u, w});
        }
        visit = new boolean[n];
        visit[0] = true;
        ans = 0;
        dfs(0, maxTime, values[0]);
        return ans;
    }

    void dfs(int u, int left, int ss) {
        if (left < 0) return;
        if (u == 0) ans = Math.max(ans, ss);
        for (int[] edge : edges[u]) {
            int v = edge[0], w = edge[1];
            if (!visit[v]) {
                visit[v] = true;
                dfs(v, left - w, ss + values[v]);
                visit[v] = false;
            } else {
                dfs(v, left - w, ss);
            }
        }
    }
}