package leetcode.normal.j518;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/coin-change-2/
 * 518. 零钱兑换 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 10];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}