package leetcode.normal.j2787;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/description/">2787. 将一个数字表示成幂的和的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n, int x) {
        // dp[i][j] 表示前 i 个数字中选择不同数字的 x 次幂之和为 j 的方案数
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            long val = (long) Math.pow(i, x);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= val) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - (int) val]) % MOD;
                }
            }
        }
        return (int) dp[n][n];
    }
}