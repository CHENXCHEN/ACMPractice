package leetcode.normal.j1351;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/description/">1351. 统计有序矩阵中的负数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0, rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] < 0) {
                    ans += cols - j;
                    break;
                }
            }
        }
        return ans;
    }
}