package leetcode.normal.j1034;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/coloring-a-border/
 * 1034. 边界着色
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int rows = grid.length, cols = grid[0].length;
        int[][] ans = Arrays.stream(grid).map(int[]::clone).toArray(int[][]::new);
        boolean[][] vis = new boolean[rows][cols];
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int from = grid[row][col];
        LinkedList<int[]> q = new LinkedList<>();
        vis[row][col] = true;
        q.add(new int[]{row, col});
        while (!q.isEmpty()) {
            int[] now = q.pop();
            int x = now[0], y = now[1];
            boolean isBoardGrid = false;
            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + x;
                int nextY = dy[i] + y;
                if (nextX < 0 || nextY < 0 || nextX >= rows || nextY >= cols) {
                    isBoardGrid = true;
                } else if (!vis[nextX][nextY]) {
                    vis[nextX][nextY] = true;
                    if (grid[nextX][nextY] == from) {
                        q.add(new int[]{nextX, nextY});
                    } else isBoardGrid = true;
                } else if (grid[nextX][nextY] != from) {
                    isBoardGrid = true;
                }
            }
            if (isBoardGrid) {
                ans[x][y] = color;
            }
        }
        return ans;
    }
}
