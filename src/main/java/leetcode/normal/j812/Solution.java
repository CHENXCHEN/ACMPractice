package leetcode.normal.j812;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/largest-triangle-area/
 * 812. 最大三角形面积
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double largestTriangleArea(int[][] points) {
        double ans = 0.0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    double a = calcDis(points[i], points[j]);
                    double b = calcDis(points[i], points[k]);
                    double c = calcDis(points[j], points[k]);
                    ans = Math.max(ans, calcArea(a, b, c));
                }
            }
        }
        return ans;
    }

    double calcDis(int[] point1, int[] point2) {
        int a = point1[0] - point2[0];
        int b = point1[1] - point2[1];
        return Math.sqrt(a * a + b * b);
    }

    double calcArea(double a, double b, double c) {
        double p = (a + b + c) / 2.0;
        double needSqrt = p * (p - a) * (p - b) * (p - c);
        if (needSqrt < 1e-6) return 0;
        if (p - a == 0 || p - b == 0 || p - c == 0) {
            System.out.println("fuck zero, a: " + a + " b: " + b + " c: " + c);
        }
        return Math.sqrt(needSqrt);
    }
}