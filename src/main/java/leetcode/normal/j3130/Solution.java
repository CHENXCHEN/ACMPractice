package leetcode.normal.j3130;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-all-possible-stable-binary-arrays-ii/description/">3130. 找出所有稳定的二进制数组 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long MOD = (long) 1e9 + 7;
        // dp[i][j][x] => 末尾为 x，放入 i 个 0， j 个 1 的方法数
        long[][][] dp = new long[zero + 1][one + 1][2];
        for (int i = 0; i <= Math.min(zero, limit); i++) dp[i][0][0] = 1;
        for (int j = 0; j <= Math.min(one, limit); j++) dp[0][j][1] = 1;
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                if (i > limit) {
                    dp[i][j][0] -= dp[i - limit - 1][j][1];
                }
                dp[i][j][0] = (dp[i][j][0] + MOD) % MOD;

                dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                if (j > limit) {
                    dp[i][j][1] -= dp[i][j - limit - 1][0];
                }
                dp[i][j][1] = (dp[i][j][1] + MOD) % MOD;
            }
        }
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}