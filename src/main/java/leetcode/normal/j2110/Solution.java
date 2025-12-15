package leetcode.normal.j2110;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-smooth-descent-periods-of-a-stock/description/">2110. 股票平滑下跌阶段的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int keep = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] + 1 == prices[i - 1]) {
                keep++;
            } else {
                keep = 0;
            }
            ans += keep + 1;
        }
        return ans;
    }
}