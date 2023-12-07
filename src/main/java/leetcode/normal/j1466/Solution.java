package leetcode.normal.j1466;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/">1466. 重新规划路线</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<int[]>[] edges;

    public int minReorder(int n, int[][] connections) {
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] connection : connections) {
            edges[connection[0]].add(new int[]{connection[1], 1});
            edges[connection[1]].add(new int[]{connection[0], 0});
        }
        return dfs(0, -1);
    }

    int dfs(int cur, int parent) {
        int ans = 0;
        for (int[] to : edges[cur]) {
            if (to[0] != parent) {
                ans += to[1] + dfs(to[0], cur);
            }
        }
        return ans;
    }
}