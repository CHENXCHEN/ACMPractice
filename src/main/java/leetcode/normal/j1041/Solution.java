package leetcode.normal.j1041;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/robot-bounded-in-circle/">1041. 困于环中的机器人</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        // 上，右，下，左
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int cur = 0;
        int[] pos = {0, 0};
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < instructions.length(); i++) {
                char ch = instructions.charAt(i);
                if (ch == 'G') {
                    pos[0] += dir[cur][0];
                    pos[1] += dir[cur][1];
                } else if (ch == 'L') {
                    cur = (cur - 1 + 4) & 3;
                } else if (ch == 'R') {
                    cur = (cur + 1) & 3;
                }
            }
        }
        return pos[0] == 0 && pos[1] == 0;
    }
}