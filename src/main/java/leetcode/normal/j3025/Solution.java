package leetcode.normal.j3025;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-number-of-ways-to-place-people-i/description/">3025. 人员站位的方案数 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] points;

    public int numberOfPairs(int[][] points) {
        this.points = points;
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (isLeftCorner(points[i], points[j])) {
                    if (!checkInRectangle(points[i], points[j], i, j)) ++ans;
                } else if (isLeftCorner(points[j], points[i])) {
                    if (!checkInRectangle(points[j], points[i], i, j)) ++ans;
                }
            }
        }
        return ans;
    }

    boolean checkInRectangle(int[] leftCorner, int[] rightCorner, int pos1, int pos2) {
        for (int i = 0; i < points.length; i++) {
            if (i == pos1 || i == pos2) continue;
            if (isInRectangle(leftCorner, rightCorner, points[i])) return true;
        }
        return false;
    }

    boolean isLeftCorner(int[] p1, int[] p2) {
        return p1[0] <= p2[0] && p1[1] >= p2[1];
    }

    boolean isInRectangle(int[] leftCorner, int[] rightCorner, int[] p) {
        return leftCorner[0] <= p[0] && p[0] <= rightCorner[0] && rightCorner[1] <= p[1] && p[1] <= leftCorner[1];
    }
}