package leetcode.normal.j1326;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-taps-to-open-to-water-a-garden/">1326. 灌溉花园的最少水龙头数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        int[][] intervals = new int[n + 1][2];
        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            intervals[i][0] = start;
            intervals[i][1] = end;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            if (dp[start] == Integer.MAX_VALUE) return -1;
            for (int j = start + 1; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[start] + 1);
            }
        }
        return dp[n];
    }
}