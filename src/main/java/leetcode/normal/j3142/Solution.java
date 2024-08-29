package leetcode.normal.j3142;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-grid-satisfies-conditions/description/">3142. 判断矩阵是否满足条件</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < rows; i++) {
                if (grid[i][j] != grid[i - 1][j]) return false;
            }
        }
        for (int j = 1; j < cols; j++) {
            if (grid[0][j - 1] == grid[0][j]) return false;
        }
        return true;
    }
}