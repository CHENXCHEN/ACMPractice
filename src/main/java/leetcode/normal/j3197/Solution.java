package leetcode.normal.j3197;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-minimum-area-to-cover-all-ones-ii/description/">3197. 包含所有 1 的最小矩形面积 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int calc(int[][] grid, int u, int d, int l, int r) {
        int minX = grid.length, maxX = 0;
        int minY = grid[0].length, maxY = 0;
        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return minX <= maxX ? (maxX - minX + 1) * (maxY - minY + 1) : Integer.MAX_VALUE / 3;
    }

    int[][] rotate(int[][] raw) {
        // 左旋转90度
        int rows = raw.length, cols = raw[0].length;
        int[][] ret = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[cols - j - 1][i] = raw[i][j];
            }
        }
        return ret;
    }

    int solve(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = rows * cols;
        for (int i = 0; i + 1 < rows; i++) {
            for (int j = 0; j + 1 < cols; j++) {
                // 枚举分为3个矩形的中间点
                res = Math.min(res, calc(grid, 0, i, 0, cols - 1) +
                        calc(grid, i + 1, rows - 1, 0, j) +
                        calc(grid, i + 1, rows - 1, j + 1, cols - 1)
                );
                res = Math.min(res, calc(grid, 0, i, 0, j) +
                        calc(grid, 0, i, j + 1, cols - 1) +
                        calc(grid, i + 1, rows - 1, 0, cols - 1));
            }
        }
        for (int i = 0; i + 2 < rows; i++) {
            for (int j = i + 1; j + 1 < rows; j++) {
                // 枚举水平三分的两个点
                res = Math.min(res, calc(grid, 0, i, 0, cols - 1) +
                        calc(grid, i + 1, j, 0, cols - 1) +
                        calc(grid, j + 1, rows - 1, 0, cols - 1));
            }
        }
        return res;
    }

    public int minimumSum(int[][] grid) {
        int[][] grid1 = rotate(grid);
        return Math.min(solve(grid), solve(grid1));
    }
}