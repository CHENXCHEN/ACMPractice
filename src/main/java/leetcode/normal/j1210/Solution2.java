package leetcode.normal.j1210;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-reach-target-with-rotations/">1210. 穿过迷宫的最少移动次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length, unValid = Integer.MAX_VALUE >> 1;
        // dp[0] -> 水平，dp[1] -> 垂直
        int[][][] dp = new int[2][n][n];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[i].length; j++)
                Arrays.fill(dp[i][j], unValid);
        // 蛇尾的最小步数
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean canHorizontal = j + 1 < n && grid[i][j] + grid[i][j + 1] == 0;
                boolean canVertical = i + 1 < n && grid[i][j] + grid[i + 1][j] == 0;
                for (int k = 0; k < 2; k++) {
                    if (k == 0 && !canHorizontal) continue;
                    if (k == 1 && !canVertical) continue;
                    if (i - 1 >= 0) dp[k][i][j] = Math.min(dp[k][i][j], dp[k][i - 1][j] + 1);
                    if (j - 1 >= 0) dp[k][i][j] = Math.min(dp[k][i][j], dp[k][i][j - 1] + 1);
                }
                if (canVertical && canHorizontal && grid[i + 1][j + 1] == 0) {
                    for (int k = 0; k < 2; k++)
                        dp[k][i][j] = Math.min(dp[k][i][j], dp[k ^ 1][i][j] + 1);
                }
            }
        }
        return dp[0][n - 1][n - 2] == unValid ? -1 : dp[0][n - 1][n - 2];
    }
}