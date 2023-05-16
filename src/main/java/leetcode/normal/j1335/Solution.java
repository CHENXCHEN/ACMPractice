package leetcode.normal.j1335;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/">1335. 工作计划的最低难度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) return -1;
        // dp[i][j] -> 0...i 在第 j 天的最小困难度是多少
        int[][] dp = new int[n][n];
        int[][] minNum = new int[n][n];
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < n; j++) {
                cur = Math.max(cur, jobDifficulty[j]);
                minNum[i][j] = cur;
            }
        }
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) dp[i][0] = minNum[0][i];
        for (int k = 1; k < d; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j][k - 1] != Integer.MAX_VALUE)
                        dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + minNum[j + 1][i]);
                }
            }
        }
        return dp[n - 1][d - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1][d - 1];
    }
}