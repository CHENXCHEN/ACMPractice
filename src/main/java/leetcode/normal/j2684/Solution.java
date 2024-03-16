package leetcode.normal.j2684;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/">2684. 矩阵中移动的最大次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    public int maxMoves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        int ans = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                for (int[] d : dir) {
                    int x = i + d[0], y = j + d[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[i][j] < grid[x][y] && (j == 0 || dp[i][j] > 0)) {
                        dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
                    }
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}