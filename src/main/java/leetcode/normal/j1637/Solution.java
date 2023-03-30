package leetcode.normal.j1637;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/widest-vertical-area-between-two-points-containing-no-points/">1637. 两点之间不包含任何点的最宽垂直区域</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (x, y) -> x[0] - y[0]);
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0] - points[i - 1][0]);
        }
        return ans;
    }
}