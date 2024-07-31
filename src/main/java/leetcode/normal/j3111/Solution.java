package leetcode.normal.j3111;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-rectangles-to-cover-points/description/">3111. 覆盖所有点的最少矩形数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, Comparator.comparingInt(x -> x[0]));
        int ans = 0, last = -1;
        for (int[] point : points) {
            int x = point[0];
            if (last == -1 || x - last > w) {
                last = x;
                ++ans;
            }
        }
        return ans;
    }
}