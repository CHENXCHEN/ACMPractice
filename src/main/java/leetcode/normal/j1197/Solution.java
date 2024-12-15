package leetcode.normal.j1197;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-knight-moves/description/">1197. 进击的骑士</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    public int minKnightMoves(int x, int y) {
        int[][] dis = new int[604][604];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < 604; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dq.add(new int[]{300, 300});
        dis[300][300] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            for (int[] dir : dirs) {
                int[] next = {cur[0] + dir[0], cur[1] + dir[1]};
                if (next[0] >= 0 && next[0] < 604 && next[1] >= 0 && next[1] < 604) {
                    if (dis[cur[0]][cur[1]] + 1 < dis[next[0]][next[1]]) {
                        dis[next[0]][next[1]] = dis[cur[0]][cur[1]] + 1;
                        dq.add(new int[]{next[0], next[1]});
                    }
                }
            }
        }
        return dis[x + 300][y + 300];
    }
}