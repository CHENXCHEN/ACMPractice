package leetcode.normal.j1706;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/where-will-the-ball-fall/description/">1706. 球会落何处</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findBall(int[][] grid) {
        // 有几种走法：左，下，右
        int[][] dirs = {{0, -1}, {1, 0}, {0, 1}};
        // 设位置为 4 种，0 左上，1 左下，2 右上，3 右下
        int rows = grid.length, cols = grid[0].length;
        // {x,y,stat}
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < cols; i++) {
            if (grid[0][i] == 1)
                deque.push(new int[]{0, i, 2, i});
            else
                deque.push(new int[]{0, i, 0, i});
        }
        int[] ans = new int[cols];
        Arrays.fill(ans, -1);

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int x = cur[0], y = cur[1], stat = cur[2], start = cur[3];
            if (x == rows - 1 && (stat == 1 || stat == 3)) {
                // 如果位于最后一行，并且状态位于左下或者右下，证明可以出去
                ans[start] = y;
            }
            if (stat == 0 && (y - 1 >= 0 && grid[x][y - 1] == -1)) {
                // 0 左上，只能往 0 左边走，且左边格子只能是 -1，下一个格子后位置变为 3 右下
                deque.push(new int[]{x, y - 1, 3, start});
            } else if (stat == 2 && (y + 1 < cols && grid[x][y + 1] == 1)) {
                // 2 右上，只能往 2 右边走，且右边格子只能是 1，下一个格子后位置变为 1左下
                deque.push(new int[]{x, y + 1, 1, start});
            } else if ((stat == 1 || stat == 3) && x + 1 < rows) {
                // 1 左下，只能往 1 下边走，且下边的格子不限制，若为 1，下一个格子为 2 右上，若为 -1，下个格子为 0
                // 3 右下，只能往 1 下边走，且下边的格子不限制，若为 1，下一个格子为 2 右上，若为 -1，下个格子为 0
                if (grid[x + 1][y] == -1) {
                    deque.push(new int[]{x + 1, y, 0, start});
                } else if (grid[x + 1][y] == 1) {
                    deque.push(new int[]{x + 1, y, 2, start});
                }
            }
        }
        return ans;
    }
}