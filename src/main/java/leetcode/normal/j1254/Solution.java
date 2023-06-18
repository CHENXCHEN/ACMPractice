package leetcode.normal.j1254;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-closed-islands/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;
    boolean[][] vis;
    int rows, cols;
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        vis = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 0) bfs(i, 0);
            if (grid[i][cols - 1] == 0) bfs(i, cols - 1);
        }
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 0) bfs(0, i);
            if (grid[rows - 1][i] == 0) bfs(rows - 1, i);
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !vis[i][j]) {
                    ++ans;
                    bfs(i, j);
                }
            }
        }
        return ans;
    }

    void bfs(int x, int y) {
        if (vis[x][y]) return;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(x * cols + y);
        while (!deque.isEmpty()) {
            int cur = deque.poll();
            int nowX = cur / cols, nowY = cur % cols;
            vis[nowX][nowY] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dir[i][0], nextY = nowY + dir[i][1];
                if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols) continue;
                if (vis[nextX][nextY] || grid[nextX][nextY] == 1) continue;
                deque.add(nextX * cols + nextY);
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int[][] grid1 = {{0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0}};
        Solution solution = new Solution();
//        System.out.println(solution.closedIsland(grid));
        System.out.println(solution.closedIsland(grid1));
    }
}