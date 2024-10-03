package leetcode.normal.j1928;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/description/">1928. 规定时间内到达终点的最小花费</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        // dp[t][i] -> 表示时间为 t 的时候到达 i 的最小花费
        int[][] dp = new int[maxTime + 1][n];
        for (int i = 0; i <= maxTime; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = passingFees[0];
        for (int t = 1; t <= maxTime; t++) {
            for (int[] e : edges) {
                int u = e[0], v = e[1], cost = e[2];
                if (cost <= t) {
                    if (dp[t - cost][v] != Integer.MAX_VALUE) {
                        dp[t][u] = Math.min(dp[t][u], dp[t - cost][v] + passingFees[u]);
                    }
                    if (dp[t - cost][u] != Integer.MAX_VALUE) {
                        dp[t][v] = Math.min(dp[t][v], dp[t - cost][u] + passingFees[v]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int t = 1; t <= maxTime; t++) ans = Math.min(ans, dp[t][n - 1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}