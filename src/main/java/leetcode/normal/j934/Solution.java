package leetcode.normal.j934;

import javafx.util.Pair;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-bridge/">934. 最短的桥</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>(), deque1 = new ArrayDeque<>();
                    deque.add(new Pair<>(i, j));
                    grid[i][j] = -1;
                    while (!deque.isEmpty()) {
                        Pair<Integer, Integer> now = deque.pop();
                        deque1.add(now);
                        for (int k = 0; k < 4; k++) {
                            Pair<Integer, Integer> next = new Pair<>(now.getKey() + dx[k], now.getValue() + dy[k]);
                            if (next.getKey() >= 0 && next.getKey() < n &&
                                    next.getValue() >= 0 && next.getValue() < n &&
                                    grid[next.getKey()][next.getValue()] == 1) {
                                grid[next.getKey()][next.getValue()] = -1;
                                deque.add(next);
                            }
                        }
                    }

                    while (!deque1.isEmpty()) {
                        Pair<Integer, Integer> now = deque1.pop();
                        for (int k = 0; k < 4; k++) {
                            Pair<Integer, Integer> next = new Pair<>(now.getKey() + dx[k], now.getValue() + dy[k]);
                            if (next.getKey() >= 0 && next.getKey() < n &&
                                    next.getValue() >= 0 && next.getValue() < n &&
                                    grid[next.getKey()][next.getValue()] >= 0
                            ) {
                                if (grid[next.getKey()][next.getValue()] == 1) {
                                    return -grid[now.getKey()][now.getValue()] - 1;
                                }
                                grid[next.getKey()][next.getValue()] = grid[now.getKey()][now.getValue()] - 1;
                                deque1.add(next);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        Solution solution = new Solution();
        solution.shortestBridge(grid);
    }
}