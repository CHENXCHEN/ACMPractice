package leetcode.normal.j1155;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/description/">1155. 掷骰子等于目标和的方法数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000000 + 7;
        long[] dp = new long[target + 1];
        dp[0] = 1L;
        for (int i = 0; i < n; i++) {
            for (int m = target; m >= 0; m--) {
                dp[m] = 0L;
                for (int j = 1; j <= k && m - j >= 0; j++) {
                    dp[m] = (dp[m] + dp[m - j]) % mod;
                }
            }
        }
        return (int)dp[target];
    }
}