package leetcode.normal.j2319;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-matrix-is-x-matrix/">2319. 判断矩阵是否是一个 X 矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || (i + j == n - 1)) {
                    if (grid[i][j] == 0) return false;
                } else if (grid[i][j] != 0) return false;
            }
        }
        return true;
    }
}