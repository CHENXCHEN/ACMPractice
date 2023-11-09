package leetcode.normal.j2258;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/escape-the-spreading-fire/">2258. 逃离火灾</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;
    int rows, cols;
    ArrayList<Integer> firePos;

    int FIRE = 1, WALL = 2, EMPTY = 0;

    public int maximumMinutes(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        firePos = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == FIRE) firePos.add(i * cols + j);
            }
        }
        int left = 0, right = 1000000000, ans = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                ans = mid;
                left = mid + 1;
            } else right = mid - 1;
        }
        return ans;
    }

    int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    boolean check(int step) {
        if (grid[0][0] == FIRE || grid[rows - 1][cols - 1] == FIRE) return false;
        int[][] subGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                subGrid[i][j] = grid[i][j];
            }
        }
        ArrayDeque<Pair<Integer, Integer>> dq = new ArrayDeque<>();
        for (Integer pos : firePos) {
            dq.add(new Pair<>(pos, 0));
        }
        while (!dq.isEmpty()) {
            Pair<Integer, Integer> now = dq.poll();
            int x = now.getKey() / cols, y = now.getKey() % cols;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (inBoard(nx, ny) && subGrid[nx][ny] == EMPTY && now.getValue() + 1 <= step) {
                    if (nx == 0 && ny == 0) return false;
                    subGrid[nx][ny] = FIRE;
                    dq.add(new Pair<>(nx * cols + ny, now.getValue() + 1));
                }
            }
        }

        int[] vis = new int[rows * cols];
        dq.add(new Pair<>(0, 0));
        vis[0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (subGrid[i][j] == FIRE) {
                    dq.add(new Pair<>(i * cols + j, 1));
                    vis[i * cols + j] = 2;
                }
            }
        }
        while (!dq.isEmpty()) {
            Pair<Integer, Integer> now = dq.poll();
            int x = now.getKey() / cols, y = now.getKey() % cols;
            if (x == rows - 1 && y == cols - 1) {
                return now.getValue() == 0;
            }
            if (now.getValue() == 0 && ((vis[now.getKey()] >> 1) & 1) == 1) continue;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                int next = nx * cols + ny;
                if (inBoard(nx, ny) && subGrid[nx][ny] == EMPTY && ((vis[next] >> now.getValue()) & 1) == 0) {
                    vis[next] |= 1 << now.getValue();
                    dq.add(new Pair<>(next, now.getValue()));
                }
            }
        }
        return false;
    }

    boolean inBoard(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 2, 0, 0, 0, 0, 0}, {0, 0, 0, 2, 2, 1, 0}, {0, 2, 0, 0, 1, 2, 0}, {0, 0, 2, 2, 2, 0, 2}, {0, 0, 0, 0, 0, 0, 0}};
//        int[][] grid = {{0, 2, 0, 0, 1}, {0, 2, 0, 2, 2}, {0, 2, 0, 0, 0}, {0, 0, 2, 2, 0}, {0, 0, 0, 0, 0}};
        Solution solution = new Solution();
        solution.maximumMinutes(grid);
    }
}