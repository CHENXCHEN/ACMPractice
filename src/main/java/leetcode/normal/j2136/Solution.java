package leetcode.normal.j2136;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/earliest-possible-day-of-full-bloom/description/">2136. 全部开花的最早一天</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] pos = new Integer[n];
        for (int i = 0; i < n; i++) pos[i] = i;
        Arrays.sort(pos, (x, y) -> growTime[y] - growTime[x]);
        int ans = 0, pre = 0;
        for (Integer idx : pos) {
            ans = Math.max(ans, pre + plantTime[idx] + growTime[idx]);
            pre += plantTime[idx];
        }
        return ans;
    }
}