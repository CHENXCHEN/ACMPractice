package leetcode.normal.j2920;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-points-after-collecting-coins-from-all-nodes/description/">2920. 收集所有金币可获得的最大积分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // dp[i][j] 表示当节点 i 进行过 j 次操作二的最大积分
    // dp[i][j] = max(dp[i'][j] + (coins[i]>>j) - k, dp[i'][j-1] + coins[i] >> (j+1))
    int[][] dp;
    int n;
    ArrayList<Integer>[] edges;
    int[] coins;

    public int maximumPoints(int[][] _edges, int[] coins, int k) {
        n = coins.length;
        dp = new int[n][14];
        this.coins = coins;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        }
        for (int[] e : _edges) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        return solve(0, -1, 0, k);
    }

    int solve(int u, int parent, int j, int k) {
        if (dp[u][j] != -1) return dp[u][j];
        // 当前节点 u 有两种选择，两种选择的初始值不同
        int res0 = (coins[u] >> j) - k;
        int res1 = coins[u] >> (j + 1);
        for (Integer v : edges[u]) {
            if (v != parent) {
                // 如果选择1
                res0 += solve(v, u, j, k);
                if (j + 1 < 14) {
                    // 如果选择 2
                    res1 += solve(v, u, j + 1, k);
                }
            }
        }
        dp[u][j] = Math.max(res0, res1);
        return dp[u][j];
    }
}