package leetcode.normal.j2304;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-path-cost-in-a-grid/description/">2304. 网格中的最小路径代价</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 1; i < rows; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int j = 0; j < cols; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            ans = Math.min(ans, dp[rows - 1][j]);
        }
        return ans;
    }
}