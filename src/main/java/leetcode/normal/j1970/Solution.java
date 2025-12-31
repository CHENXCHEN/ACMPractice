package leetcode.normal.j1970;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/last-day-where-you-can-still-cross/description/">1970. 你能穿过矩阵的最后一天</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int row, col;
    int[][] cells;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        this.row = row;
        this.col = col;
        this.cells = cells;
        int left = 0, right = row * col, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (bfs(mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    boolean bfs(int k) {
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) Arrays.fill(grid[i], 1);
        for (int i = 0; i < k; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 0;
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 1) {
                queue.add(new int[]{0, j});
                grid[0][j] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0], y = poll[1];
            if (x == row - 1) return true;
            for (int[] dir : dir) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    grid[nx][ny] = 0;
                }
            }
        }
        return false;
    }
}