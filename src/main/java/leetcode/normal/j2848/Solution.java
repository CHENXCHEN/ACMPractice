package leetcode.normal.j2848;

import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/points-that-intersect-with-cars/description/">2848. 与车相交的点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] rc = new int[102];
        for (List<Integer> pair : nums) {
            rc[pair.get(0)]++;
            rc[pair.get(1) + 1]--;
        }
        int ans = 0, cnt = 0;
        for (int i = 1; i <= 100; i++) {
            cnt += rc[i];
            if (cnt > 0) ans++;
        }
        return ans;
    }
}