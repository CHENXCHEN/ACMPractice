package leetcode.normal.j1401;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/circle-and-rectangle-overlapping/">1401. 圆和矩形是否有重叠</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double distance = 0.0;
        // 如果圆心在矩形左边或者右边
        if (xCenter < x1 || x2 < xCenter) {
            distance += Math.min(Math.pow(xCenter - x1, 2), Math.pow(xCenter - x2, 2));
        }
        // 如果圆心在矩形的下边或者上边
        if (yCenter < y1 || y2 < yCenter) {
            distance += Math.min(Math.pow(yCenter - y1, 2), Math.pow(yCenter - y2, 2));
        }
        return distance <= radius * radius;
    }
}