package leetcode.normal.j1289;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-falling-path-sum-ii/">1289. 下降路径最小和 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[2][cols];
        int cur = 0;
        int[] preMin = new int[2], prePos = new int[2];
        Arrays.fill(preMin, Integer.MAX_VALUE);
        for (int i = 0; i < cols; i++) {
            dp[cur][i] = grid[0][i];
            update(preMin, prePos, i, dp[cur][i]);
        }
        for (int i = 1; i < rows; i++) {
            cur ^= 1;
            Arrays.fill(dp[cur], Integer.MAX_VALUE);
            for (int j = 0; j < cols; j++) {
                if (prePos[0] != j) {
                    dp[cur][j] = Math.min(dp[cur][j], grid[i][j] + preMin[0]);
                } else {
                    dp[cur][j] = Math.min(dp[cur][j], grid[i][j] + preMin[1]);
                }
            }
            Arrays.fill(preMin, Integer.MAX_VALUE);
            for (int j = 0; j < cols; j++)
                update(preMin, prePos, j, dp[cur][j]);
        }
        int ans = dp[cur][0];
        for (int i = 1; i < cols; i++) ans = Math.min(ans, dp[cur][i]);
        return ans;
    }

    void update(int[] preMin, int[] prePos, int pos, int v) {
        if (v < preMin[0]) {
            preMin[1] = preMin[0];
            prePos[1] = prePos[0];
            preMin[0] = v;
            prePos[0] = pos;
        } else if (v < preMin[1]) {
            preMin[1] = v;
            prePos[1] = pos;
        }
    }
}