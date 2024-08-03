package leetcode.normal.j3143;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-points-inside-the-square/description/">3143. 正方形中的最多点数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] points;
    String tag;

    public int maxPointsInsideSquare(int[][] points, String s) {
        this.points = points;
        tag = s;
        int left = 0, right = (int) 1e9, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int res = calc(mid);
            if (res == -1) {
                right = mid - 1;
            } else {
                ans = Math.max(res, ans);
                left = mid + 1;
            }
        }
        return ans;
    }

    int calc(int r) {
        boolean[] has = new boolean[26];
        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            int x = Math.abs(points[i][0]), y = Math.abs(points[i][1]);
            if (x <= r && y <= r) {
                int tagPos = tag.charAt(i) - 'a';
                if (has[tagPos]) return -1;
                has[tagPos] = true;
                ++cnt;
            }
        }
        return cnt;
    }
}