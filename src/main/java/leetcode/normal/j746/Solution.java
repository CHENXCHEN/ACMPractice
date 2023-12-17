package leetcode.normal.j746;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">746. 使用最小花费爬楼梯</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return Math.min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2]);
    }
}