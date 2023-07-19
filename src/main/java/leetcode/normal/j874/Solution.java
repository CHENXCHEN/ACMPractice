package leetcode.normal.j874;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/walking-robot-simulation/">874. 模拟行走机器人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        TreeMap<Integer, TreeSet<Integer>> xAxis = new TreeMap<>(), yAxis = new TreeMap<>();
        for (int[] obstacle : obstacles) {
            int cx = obstacle[0], cy = obstacle[1];
            if (!xAxis.containsKey(cx)) {
                xAxis.put(cx, new TreeSet<>());
            }
            xAxis.get(cx).add(cy);
            if (!yAxis.containsKey(cy)) {
                yAxis.put(cy, new TreeSet<>());
            }
            yAxis.get(cy).add(cx);
        }
        int x = 0, y = 0, ans = 0;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        for (int command : commands) {
            if (command > 0) {
                int nextX = x + command * dir[d][0], nextY = y + command * dir[d][1];
                if (x == nextX) {
                    nextY = findLess(xAxis.get(x), y, nextY);
                } else if (y == nextY) {
                    nextX = findLess(yAxis.get(y), x, nextX);
                }
                ans = Math.max(ans, nextY * nextY + nextX * nextX);
                x = nextX;
                y = nextY;
            } else if (command == -1) {
                d = (d + 1) & 3;
            } else if (command == -2) {
                d = (d + 3) & 3;
            }
        }
        return ans;
    }

    int findLess(TreeSet<Integer> tSet, int first, int next) {
        if (tSet == null) return next;
        if (first < next) {
            Integer higher = tSet.higher(first);
            if (higher != null && next >= higher) return higher - 1;
            return next;
        } else {
            Integer lower = tSet.lower(first);
            if (lower != null && lower >= next) return lower + 1;
            return next;
        }
    }

    public static void main(String[] args) {
        // [4,-1,4,-2,4]
        //[[2,4]]
        // [2,2,5,-1,-1]
        // [[-3,5],[-2,5],[3,2],[5,0],[-2,0],[-1,5],[5,-3],[0,0],[-4,4],[-3,4]]
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        Solution solution = new Solution();
        solution.robotSim(commands, obstacles);
    }
}