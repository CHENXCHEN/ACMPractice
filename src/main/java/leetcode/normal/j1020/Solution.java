package leetcode.normal.j1020;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/number-of-enclaves/
 * 1020. 飞地的数量
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    class Node {
        int x, y;

        Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    public int numEnclaves(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Node> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for (int col = 0; col < cols; col++) {
            if (grid[0][col] == 1) {
                q.add(new Node(0, col));
                vis[0][col] = true;
            }
            if (grid[rows - 1][col] == 1) {
                q.add(new Node(rows - 1, col));
                vis[rows - 1][col] = true;
            }
        }
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] == 1) {
                q.add(new Node(row, 0));
                vis[row][0] = true;
            }
            if (grid[row][cols - 1] == 1) {
                q.add(new Node(row, cols - 1));
                vis[row][cols - 1] = true;
            }
        }
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                Node next = new Node(now.x + dx[i], now.y + dy[i]);
                if (next.x >= 0 && next.x < rows && next.y >= 0 && next.y < cols) {
                    if (grid[next.x][next.y] == 1 && !vis[next.x][next.y]) {
                        q.add(next);
                        vis[next.x][next.y] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) ++ ans;
            }
        }
        return ans;
    }
}