package leetcode.normal.j983;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-for-tickets/description/">983. 最低票价</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // dp[i] => 到 days[i] 为止，花费最小数是多少
        // dp[i] = Math.min(dp[i-1] + costs[0], dp[j] + costs[1], dp[k] + costs[2])
        // days[j] < i - 7, days[k] < i - 30
        int n = days.length;
        int[] dp = new int[n];
        for (int i = 0, j = 0, k = 0; i < n; i++) {
            while (days[i] - days[j] >= 7) j++;
            while (days[i] - days[k] >= 30) k++;
            int d1 = (i == 0 ? 0 : dp[i - 1]) + costs[0];
            int d7 = (j == 0 ? 0 : dp[j - 1]) + costs[1];
            int d30 = (k == 0 ? 0 : dp[k - 1]) + costs[2];
            dp[i] = Math.min(d1, Math.min(d7, d30));
        }
        return dp[n - 1];
    }
}