package leetcode.normal.j1000;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-to-merge-stones/">1000. 合并石头的最低成本</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        int[] preSum = new int[n + 1];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][i] = 0;
        }
        for (int len = 1; len < n; len++) {
            for (int left = 0; left + len < n; left++) {
                int right = left + len;
                for (int i = left; i < right; i += k - 1) {
                    dp[left][right] = Math.min(dp[left][right], dp[left][i] + dp[i + 1][right]);
                }
                if ((right - left) % (k - 1) == 0) {
                    dp[left][right] += preSum[right + 1] - preSum[left];
                }
            }
        }
        return dp[0][n - 1];
    }
}