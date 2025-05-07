package leetcode.normal.j3341;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-i/description/">3341. 到达最后一个房间的最少时间 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length;
        int[][] dis = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.pop();
            int preX = cur[0], preY = cur[1];
            for (int[] dir : dir) {
                int x = preX + dir[0], y = preY + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    int nextStep = Math.max(moveTime[x][y], dis[preX][preY]) + 1;
                    if (dis[x][y] > nextStep) {
                        dis[x][y] = nextStep;
                        deque.add(new int[]{x, y});
                    }
                }
            }
        }
        return dis[rows - 1][cols - 1];
    }
}