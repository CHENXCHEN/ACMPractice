package leetcode.normal.j1289;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum-ii/">1289. 下降路径最小和 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[2][cols];
        int cur = 0;
        for (int i = 0; i < cols; i++) {
            dp[cur][i] = grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            cur ^= 1;
            Arrays.fill(dp[cur], Integer.MAX_VALUE);
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    if (j != k) {
                        dp[cur][j] = Math.min(dp[cur][j], grid[i][j] + dp[cur ^ 1][k]);
                    }
                }
            }
        }
        int ans = dp[cur][0];
        for (int i = 1; i < cols; i++) ans = Math.min(ans, dp[cur][i]);
        return ans;
    }
}