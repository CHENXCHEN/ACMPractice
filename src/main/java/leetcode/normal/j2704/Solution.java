package leetcode.normal.j2704;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/">剑指 Offer 47. 礼物的最大价值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxValue(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = i > 0 ? dp[i - 1][j] : 0;
                int left = j > 0 ? dp[i][j - 1] : 0;
                dp[i][j] = grid[i][j] + Math.max(up, left);
            }
        }
        return dp[rows - 1][cols - 1];
    }
}