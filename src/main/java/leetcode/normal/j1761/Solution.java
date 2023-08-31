package leetcode.normal.j1761;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/description/">1761. 一个图中连通三元组的最小度数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minTrioDegree(int n, int[][] _edges) {
        int[] du = new int[n + 1];
        boolean[][] edges = new boolean[n + 1][n + 1];
        for (int[] edge : _edges) {
            edges[edge[0]][edge[1]] = edges[edge[1]][edge[0]] = true;
            ++du[edge[0]];
            ++du[edge[1]];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (edges[i][j]) {
                    for (int k = j + 1; k <= n; k++) {
                        if (edges[j][k] && edges[k][i]) {
                            ans = Math.min(ans, du[i] + du[j] + du[k] - 6);
                        }
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}