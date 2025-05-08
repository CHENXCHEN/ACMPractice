package leetcode.normal.j3342;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-minimum-time-to-reach-last-room-ii/">3342. 到达最后一个房间的最少时间 II</a>
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
        PriorityQueue<int[]> deque = new PriorityQueue<>((first, second) -> {
            return Integer.compare(dis[first[0]][first[1]], dis[second[0]][second[1]]);
        });
        deque.add(new int[]{0, 0, 0});
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int preX = cur[0], preY = cur[1], cnt = cur[2];
            for (int[] dir : dir) {
                int x = preX + dir[0], y = preY + dir[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    int nextStep = Math.max(dis[preX][preY], moveTime[x][y]) + (cnt % 2 == 0 ? 1 : 2);
                    if (nextStep < dis[x][y]) {
                        dis[x][y] = nextStep;
                        deque.add(new int[]{x, y, cnt + 1});
                    }
                }
            }
        }
        return dis[rows - 1][cols - 1];
    }
}