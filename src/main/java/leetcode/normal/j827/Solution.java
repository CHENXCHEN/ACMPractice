package leetcode.normal.j827;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/making-a-large-island/">827. 最大人工岛</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;
    int[][] vis;
    int tot = 0, rows = 0, cols = 0;
    ArrayList<Integer> cnts;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        cnts = new ArrayList<>();
        tot = 0;
        rows = grid.length;
        cols = grid[0].length;
        vis = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) bfs(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int tmp = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k], y = j + dy[k];
                        if (0 <= x && x < rows && 0 <= y && y < cols && grid[x][y] == 1 && !set.contains(vis[x][y])) {
                            set.add(vis[x][y]);
                            tmp += cnts.get(vis[x][y] - 1);
                        }
                    }
                    ans = Math.max(ans, tmp);
                } else ans = Math.max(ans, cnts.get(vis[i][j] - 1));
            }
        }
        return ans;
    }

    void bfs(int x, int y) {
        int cnt = 0;
        ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        vis[x][y] = ++tot;
        deque.add(new Pair<>(x, y));
        while (!deque.isEmpty()) {
            Pair<Integer, Integer> now = deque.pop();
            ++cnt;
            for (int i = 0; i < 4; i++) {
                Pair<Integer, Integer> next = new Pair<>(now.getKey() + dx[i], now.getValue() + dy[i]);
                if (next.getKey() >= 0 && next.getKey() < rows && next.getValue() >= 0 && next.getValue() < cols) {
                    if (grid[next.getKey()][next.getValue()] == 1 && vis[next.getKey()][next.getValue()] == 0) {
                        vis[next.getKey()][next.getValue()] = tot;
                        deque.add(next);
                    }
                }
            }
        }
        cnts.add(cnt);
    }
}