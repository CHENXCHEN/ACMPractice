package leetcode.normal.j1091;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/">1091. 二进制矩阵中的最短路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) return -1;
        int rows = grid.length, cols = grid[0].length;
        int[] dis = new int[rows * cols];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        dis[0] = 1;
        while (!deque.isEmpty()) {
            Integer cur = deque.poll();
            int x = cur / cols, y = cur % cols;
            if (x == rows - 1 && y == cols - 1) return dis[cur];
            for (int i = x - 1; i <= x + 1; i++) {
                if (i < 0 || i >= rows) continue;
                for (int j = y - 1; j <= y + 1; j++) {
                    if (j < 0 || j >= cols) continue;
                    if (i == x && j == y) continue;
                    int next = i * cols + j;
                    if (grid[i][j] == 0 && dis[next] == 0) {
                        dis[next] = dis[cur] + 1;
                        deque.add(next);
                    }
                }
            }
        }
        return -1;
    }
}