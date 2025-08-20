package leetcode.normal.j1277;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-square-submatrices-with-all-ones/description/">1277. 统计全为 1 的正方形子矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        // dp[i][j] 表示以 (i,j) 格子为右下角为正方形最大边长，其实也是以 (i,j) 点为右下角的正方形数
        int[][] dp = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}