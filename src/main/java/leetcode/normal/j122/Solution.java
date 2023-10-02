package leetcode.normal.j122;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">122. 买卖股票的最佳时机 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxProfit(int[] prices) {
        // dp[0] -> 到当前为止，手上没有股票的最大收益
        // dp[1] -> 到当前为止，手上有股票的最大收益
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int next0 = Math.max(dp[0], dp[1] + prices[i]);
            int next1 = Math.max(dp[1], dp[0] - prices[i]);
            dp[0] = next0;
            dp[1] = next1;
        }
        return dp[0];
    }
}