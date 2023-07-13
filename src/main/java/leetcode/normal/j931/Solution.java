package leetcode.normal.j931;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum/">931. 下降路径最小和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        // 滚动数组，每一层的结果只能由上一层得出
        int[][] dp = new int[2][cols];
        int cur = 1;
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < rows; i++) {
            Arrays.fill(dp[cur], Integer.MAX_VALUE);
            for (int j = 0; j < cols; j++) {
                for (int py = j - 1; py <= j + 1; py++) {
                    if (py >= 0 && py < cols) {
                        dp[cur][j] = Math.min(dp[cur][j], dp[cur ^ 1][py] + matrix[i][j]);
                    }
                }
            }
            cur ^= 1;
        }
        cur ^= 1;
        int ans = dp[cur][0];
        for (int j = 1; j < cols; j++) ans = Math.min(ans, dp[cur][j]);
        return ans;
    }
}