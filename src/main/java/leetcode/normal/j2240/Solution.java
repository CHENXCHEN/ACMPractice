package leetcode.normal.j2240;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-ways-to-buy-pens-and-pencils/">2240. 买钢笔和铅笔的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long ans = 0;
        while (total >= 0) {
            ans += total / cost2 + 1L;
            total -= cost1;
        }
        return ans;
    }
}