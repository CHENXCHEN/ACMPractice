package leetcode.normal.j1779;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/">1779. 找到最近的有相同 X 或 Y 坐标的点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1, ansSum = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int tmp = getDis(x, y, point[0], point[1]);
                if (ansSum == -1 || tmp < ansSum) {
                    ans = i;
                    ansSum = tmp;
                }
            }
        }
        return ans;
    }

    int getDis(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }
}