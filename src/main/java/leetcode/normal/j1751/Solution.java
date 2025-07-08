package leetcode.normal.j1751;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-events-that-can-be-attended-ii/description/">1751. 最多可以参加的会议数目 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            // 找到左边最大的合法位置
            int p = lowerRight(events, events[i][0]);
            for (int j = 1; j <= k; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[p][j - 1] + events[i][2]);
            }
        }
        return dp[n][k];
    }

    int lowerRight(int[][] events, int target) {
        int left = 0, right = events.length - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (events[mid][1] < target) {
                ans = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}