package leetcode.normal.j2073;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/time-needed-to-buy-tickets/description/">2073. 买票需要的时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                ans += Math.min(tickets[k], tickets[i]);
            } else {
                ans += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return ans;
    }
}