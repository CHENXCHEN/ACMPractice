package leetcode.normal.j3169;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-days-without-meetings/description/">3169. 无需开会的工作日</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countDays(int days, int[][] meetings) {
        int ans = 0, last = 0;
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            int cnt = meeting[0] - last - 1;
            if (cnt > 0) ans += cnt;
            last = Math.max(last, meeting[1]);
        }
        int cnt = days - last;
        if (cnt > 0) ans += cnt;
        return ans;
    }
}