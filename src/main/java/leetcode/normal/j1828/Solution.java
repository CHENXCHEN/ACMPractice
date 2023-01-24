package leetcode.normal.j1828;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/">1828. 统计一个圆中点的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int[] point : points) {
                if (check(point, queries[i])) {
                    ++ans[i];
                }
            }
        }
        return ans;
    }

    boolean check(int[] point, int[] query) {
        int diffX = point[0] - query[0];
        int diffY = point[1] - query[1];
        return diffX * diffX + diffY * diffY <= query[2] * query[2];
    }
}