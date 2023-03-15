package leetcode.normal.j1615;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximal-network-rank/">1615. 最大网络秩</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] vis = new boolean[n][n];
        int[] cnt = new int[n];
        for (int[] road : roads) {
            int from = road[0], to = road[1];
            if (from > to) {
                from = road[1];
                to = road[0];
            }
            if (!vis[from][to]) {
                vis[from][to] = true;
                ++cnt[from];
                ++cnt[to];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, cnt[i] + cnt[j] - (vis[i][j] ? 1 : 0));
            }
        }
        return ans;
    }
}