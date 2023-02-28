package leetcode.normal.j121;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">121. 买卖股票的最佳时机</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        // 从左往右数，只有最小的价格对其右边的有贡献，因此记住最小价格，用最小价格来对比即可
        for (int price : prices) {
            if (price < min) min = price;
            else if (price - min > ans) ans = price - min;
        }
        return ans;
    }
}