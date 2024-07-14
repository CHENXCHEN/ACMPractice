package leetcode.normal.j807;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/max-increase-to-keep-city-skyline/">807. 保持城市天际线</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] mxRow = new int[rows], mxCol = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mxRow[i] = Math.max(mxRow[i], grid[i][j]);
                mxCol[j] = Math.max(mxCol[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans += Math.min(mxRow[i], mxCol[j]) - grid[i][j];
            }
        }
        return ans;
    }
}