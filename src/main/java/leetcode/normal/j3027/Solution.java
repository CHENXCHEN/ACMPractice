package leetcode.normal.j3027;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-number-of-ways-to-place-people-ii/description/">3027. 人员站位的方案数 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfPairs(int[][] points) {
        // 按 x 升序排，x 相等的情况按 y 降序排
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            // 对于每一个点，作为左上角坐标，枚举右下角
            int[] pointA = points[i];
            int xMin = pointA[0] - 1;
            int xMax = Integer.MAX_VALUE;
            int yMin = Integer.MIN_VALUE;
            int yMax = pointA[1] + 1;

            // 因为 x 已经升序排了，那么对于复合的右下角点，其 y 也一定是升序的，因此枚举之后维护 x 和 y 的范围
            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if (pointB[0] > xMin && pointB[0] < xMax &&
                        pointB[1] > yMin && pointB[1] < yMax) {
                    ans++;
                    xMin = pointB[0];
                    yMin = pointB[1];
                }
            }
        }
        return ans;
    }
}