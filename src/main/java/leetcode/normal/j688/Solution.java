package leetcode.normal.j688;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/knight-probability-in-chessboard/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        // dp[step][i][j] 表示从 (i,j) 出发，走了 step 步，还留在棋盘上的概率
        // dp[step][i][j] = sum(dp[step][i-dx][j-dy])/8
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) dp[step][i][j] = 1;
                    else {
                        for (int[] dir : dirs) {
                            int x = i + dir[0], y = j + dir[1];
                            if (x < 0 || x >= n || y < 0 || y >= n) continue;
                            dp[step][i][j] += dp[step - 1][x][y] / 8;
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
}