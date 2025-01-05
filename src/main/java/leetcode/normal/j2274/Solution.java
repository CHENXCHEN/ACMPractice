package leetcode.normal.j2274;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/description/">2274. 不含特殊楼层的最大连续楼层数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = special[0] - bottom;
        for (int i = 1; i < special.length; i++) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        ans = Math.max(ans, top - special[special.length - 1]);
        return ans;
    }
}