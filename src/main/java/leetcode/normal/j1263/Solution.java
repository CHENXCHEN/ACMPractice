package leetcode.normal.j1263;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/">1263. 推箱子</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;
    char[][] grid;

    public int minPushBox(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = grid;
        int _startX = -1, _startY = -1, _boxX = -1, _boxY = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'B') {
                    _boxX = i;
                    _boxY = j;
                } else if (grid[i][j] == 'S') {
                    _startX = i;
                    _startY = j;
                }
            }
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] dis = new int[rows * cols][rows * cols];
        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        Pair<Integer, Integer> entry = new Pair<>(_boxX * cols + _boxY, _startX * cols + _startY);
        deque.add(entry);
        dis[entry.getKey()][entry.getValue()] = 0;
        int ans = -1;
        while (!deque.isEmpty()) {
            Pair<Integer, Integer> now = deque.poll();
            int boxPos = now.getKey(), startPos = now.getValue();
            int startX = startPos / cols, startY = startPos % cols;
            int boxX = boxPos / cols, boxY = boxPos % cols;
            if (grid[boxX][boxY] == 'T') {
                if (ans == -1) ans = dis[boxPos][startPos];
                else ans = Math.min(ans, dis[boxPos][startPos]);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = startX + dir[i][0], nextY = startY + dir[i][1], nextPos = nextX * cols + nextY;
                if (!isOk(nextX, nextY)) {
                    continue;
                }
                if (nextX == boxX && nextY == boxY) {
                    int nextBoxX = boxX + dir[i][0], nextBoxY = boxY + dir[i][1];
                    if (!isOk(nextBoxX, nextBoxY)) {
                        continue;
                    }
                    int nextBoxPos = nextBoxX * cols + nextBoxY;
                    if (dis[boxPos][startPos] + 1 < dis[nextBoxPos][nextPos]) {
                        dis[nextBoxPos][nextPos] = dis[boxPos][startPos] + 1;
                        deque.add(new Pair<>(nextBoxPos, nextPos));
                    }
                } else {
                    if (dis[boxPos][startPos] < dis[boxPos][nextPos]) {
                        dis[boxPos][nextPos] = dis[boxPos][startPos];
                        deque.add(new Pair<>(boxPos, nextPos));
                    }
                }
            }
        }
        return ans;
    }

    boolean isOk(int x, int y) {
        return 0 <= x && x < rows && 0 <= y && y < cols && grid[x][y] != '#';
    }
}