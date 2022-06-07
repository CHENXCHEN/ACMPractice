package leetcode.normal.j1037;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/valid-boomerang/
 * 1037. 有效的回旋镖
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isBoomerang(int[][] points) {
        // dx / dy == dx1 / dy1
        int[] dx = {points[0][0] - points[1][0], points[1][0] - points[2][0]};
        int[] dy = {points[0][1] - points[1][1], points[1][1] - points[2][1]};
        return dx[0] * dy[1] - dx[1] * dy[0] != 0;
    }
}