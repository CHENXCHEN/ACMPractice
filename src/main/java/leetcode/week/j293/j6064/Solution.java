package leetcode.week.j293.j6064;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/maximum-consecutive-floors-without-special-floors/
 * 6064. 不含特殊楼层的最大连续楼层数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int ans = 0;
        int lastSpecial = special[0];
        ans = Math.max(lastSpecial - bottom, ans);
        for (int i = 0; i < special.length; i++) {
            if (special[i] != lastSpecial) {
                ans = Math.max(special[i] - lastSpecial - 1, ans);
                lastSpecial = special[i];
            }
        }
        ans = Math.max(top - lastSpecial, ans);
        return ans;
    }
}