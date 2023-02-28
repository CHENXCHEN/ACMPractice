package leetcode.normal.j121;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] preMin = new int[n], preMax = new int[n];
        preMin[0] = prices[0];
        for (int i = 1; i < n; i++) {
            preMin[i] = Math.min(preMin[i - 1], prices[i]);
        }
        preMax[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            preMax[i] = Math.max(preMax[i + 1], prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans = Math.max(ans, preMax[i + 1] - preMin[i]);
        }
        return ans;
    }
}