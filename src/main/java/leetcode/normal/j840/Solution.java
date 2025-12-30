package leetcode.normal.j840;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/magic-squares-in-grid/description/">840. 矩阵中的幻方</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;

    public int numMagicSquaresInside(int[][] grid) {
        this.grid = grid;
        int rows = grid.length, cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i + 2 < rows; i++) {
            for (int j = 0; j + 2 < cols; j++) {
                if (check(i, j)) ++ans;
            }
        }
        return ans;
    }

    boolean check(int row, int col) {
        int[] vis = new int[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[row + i][col + j] < 1 || grid[row + i][col + j] > 9) return false;
                if (vis[grid[row + i][col + j]] == 1) return false;
                vis[grid[row + i][col + j]] = 1;
            }
        }
        int cur = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        // 行
        for (int i = 0; i < 3; i++) {
            int res = 0;
            for (int j = 0; j < 3; j++) {
                res += grid[row + i][col + j];
            }
            if (res != cur) return false;
        }
        // 列
        for (int j = 0; j < 3; j++) {
            int res = 0;
            for (int i = 0; i < 3; i++) {
                res += grid[row + i][col + j];
            }
            if (res != cur) return false;
        }
        // 斜线
        int r1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int r2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        return r1 == cur && r2 == cur;
    }
}