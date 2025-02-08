package leetcode.normal.j63;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/">63. 不同路径 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 0) {
                    int leftCnt = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    int upCnt = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    dp[i][j] = leftCnt + upCnt;
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
}