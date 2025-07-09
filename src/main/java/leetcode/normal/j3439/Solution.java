package leetcode.normal.j3439;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reschedule-meetings-for-maximum-free-time-i/description/">3439. 重新安排会议得到最多空余时间 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length, ans = 0;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            // 枚举当前位置 i 为连续 k 个会议的最右边
            int left = i == k - 1 ? 0 : endTime[i - k];
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            ans = Math.max(ans, right - left - (preSum[i + 1] - preSum[i - k + 1]));
        }
        return ans;
    }
}