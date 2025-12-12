package leetcode.normal.j3531;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-covered-buildings/description/">3531. 统计被覆盖的建筑</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] xMax = new int[n + 1], xMin = new int[n + 1];
        int[] yMax = new int[n + 1], yMin = new int[n + 1];
        Arrays.fill(xMin, Integer.MAX_VALUE);
        Arrays.fill(yMin, Integer.MAX_VALUE);
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            xMax[x] = Math.max(y, xMax[x]);
            xMin[x] = Math.min(y, xMin[x]);
            yMax[y] = Math.max(x, yMax[y]);
            yMin[y] = Math.min(x, yMin[y]);
        }
        int ans = 0;
        for (int[] building : buildings) {
            int x = building[0], y = building[1];
            if (xMin[x] < y && y < xMax[x] && yMin[y] < x && x < yMax[y]) {
                ++ans;
            }
        }
        return ans;
    }
}