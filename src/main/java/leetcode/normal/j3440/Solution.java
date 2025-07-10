package leetcode.normal.j3440;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-ii/description/">3440. 重新安排会议得到最多空余时间 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = endTime.length, last = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int len = startTime[i] - last;
            ans = Math.max(ans, len);
            if (len > 0) {
                map.compute(len, (k, v) -> v == null ? 1 : v + 1);
            }
            last = endTime[i];
        }
        if (eventTime - last > 0) {
            map.compute(eventTime - last, (k, v) -> v == null ? 1 : v + 1);
        }
        for (int i = 0; i < n; i++) {
            int left = i == 0 ? 0 : endTime[i - 1];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            int len0 = endTime[i] - startTime[i];
            int len1 = startTime[i] - left;
            int len2 = right - endTime[i];
            if (len1 > 0) map.compute(len1, (k, v) -> v == 1 ? null : v - 1);
            if (len2 > 0) map.compute(len2, (k, v) -> v == 1 ? null : v - 1);
            if (map.ceilingEntry(len0) != null) {
                ans = Math.max(ans, right - left);
            } else {
                ans = Math.max(ans, right - left - len0);
            }
            if (len1 > 0) map.compute(len1, (k, v) -> v == null ? 1 : v + 1);
            if (len2 > 0) map.compute(len2, (k, v) -> v == null ? 1 : v + 1);
        }
        return ans;
    }
}