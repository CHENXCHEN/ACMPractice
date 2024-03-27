package leetcode.normal.j2580;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/description/">2580. 统计将重叠区间合并成组的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int countWays(int[][] ranges) {
        int ans = 1, mod = (int) 1e9 + 7, i = 0, n = ranges.length;
        Arrays.sort(ranges, (x, y) -> Integer.compare(x[0], y[0]));
        while (i < n) {
            int j = i + 1;
            int r = ranges[i][1];
            while (j < n && ranges[j][0] <= r) {
                r = Math.max(r, ranges[j][1]);
                j++;
            }
            ans = (ans << 1) % mod;
            i = j;
        }
        return ans;
    }
}