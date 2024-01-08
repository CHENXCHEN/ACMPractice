package leetcode.normal.j447;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-boomerangs/description/">447. 回旋镖的数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> cnt = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                cnt.compute(calc(points[i], points[j]), (k, v) -> (v == null ? 0 : v) + 1);
            }
            for (Integer count : cnt.values()) {
                if (count > 1) {
                    ans += count * (count - 1);
                }
            }
        }
        return ans;
    }

    boolean check(int[] point1, int[] point2, int[] point3) {
        return calc(point1, point2) == calc(point1, point3);
    }

    int calc(int[] point1, int[] point2) {
        int diff1 = point1[0] - point2[0], diff2 = point1[1] - point2[1];
        return diff1 * diff1 + diff2 * diff2;
    }
}