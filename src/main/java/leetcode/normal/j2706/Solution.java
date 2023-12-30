package leetcode.normal.j2706;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/buy-two-chocolates/description/">2706. 购买两块巧克力</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int predict = prices[0] + prices[1];
        return predict <= money ? money - predict : money;
    }
}