package leetcode.normal.jlcp06;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/na-ying-bi/description/">LCP 06. 拿硬币</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin + 1) / 2;
        }
        return ans;
    }
}