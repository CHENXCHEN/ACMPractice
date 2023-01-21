package leetcode.normal.j1824;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-sideway-jumps/">1824. 最少侧跳次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] vis = new int[3][n];
        for (int i = 0; i < 3; i++) Arrays.fill(vis[i], -1);
        vis[2][0] = vis[0][0] = 1;
        vis[1][0] = 0;
        ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(0, 0));
        deque.add(new Pair<>(1, 0));
        deque.add(new Pair<>(2, 0));
        int[] dx = {0, 1, -1};
        int[] dy = {1, 0, 0};
        while (!deque.isEmpty()) {
            Pair<Integer, Integer> now = deque.poll();
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    Pair<Integer, Integer> next = new Pair<>(now.getKey() + dx[i] * j, now.getValue() + dy[i]);
                    if (next.getKey() >= 0 && next.getKey() <= 2 && next.getValue() < n
                            && obstacles[next.getValue()] - 1 != next.getKey()) {
                        int step = 0;
                        if (i > 0) step = 1;
                        if (vis[next.getKey()][next.getValue()] == -1 ||
                                vis[now.getKey()][now.getValue()] + step < vis[next.getKey()][next.getValue()]) {
                            vis[next.getKey()][next.getValue()] = vis[now.getKey()][now.getValue()] + step;
                            deque.add(next);
                        }
                    }
                }
            }
        }
        return getMin(vis[0][n - 1], getMin(vis[1][n - 1], vis[2][n - 1]));
    }

    void processNext() {

    }

    int getMin(int num1, int num2) {
        if (num1 < 0) return num2;
        if (num2 < 0) return num1;
        return Math.min(num1, num2);
    }
}