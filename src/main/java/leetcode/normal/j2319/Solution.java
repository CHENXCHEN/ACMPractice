package leetcode.normal.j2319;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-matrix-is-x-matrix/">2319. 判断矩阵是否是一个 X 矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;
    int n;

    public boolean checkXMatrix(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        int[][] dir = {{1, 1}, {1, -1}};
        int[][] pos = {{0, 0}, {0, n - 1}};
        for (int i = 0; i < 2; i++) {
            if (!check(pos[i][0], pos[i][1], dir[i])) return false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) return false;
            }
        }
        return true;
    }

    boolean check(int x, int y, int[] d) {
        while (0 <= x && x < n && 0 <= y && y < n) {
            if (grid[x][y] == 0) return false;
            grid[x][y] = -1;
            x += d[0];
            y += d[1];
        }
        return true;
    }
}