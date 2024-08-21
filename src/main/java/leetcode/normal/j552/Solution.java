package leetcode.normal.j552;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/student-attendance-record-ii/description/">552. 学生出勤记录 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public int checkRecord(int n) {
        int MOD = (int) 1e9 + 7;
        // dp[i][j][k] => 1..i 为止，出现了 j 次 A，连续出现了 k 次 L 的方法数
        long[][][] dp = new long[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 如果第 i 天的记录是 P，那么 L 的记录清空
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] += Arrays.stream(dp[i - 1][j]).sum();
                dp[i][j][0] %= MOD;
            }
            // 如果第 i 天的记录是 A
            dp[i][1][0] += Arrays.stream(dp[i - 1][0]).sum();
            dp[i][1][0] %= MOD;
            // 如果第 i 天的记录是 L
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] += dp[i - 1][j][k - 1];
                    dp[i][j][k] %= MOD;
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 2; j++) {
            ans += (int) (Arrays.stream(dp[n][j]).sum() % MOD);
            ans %= MOD;
        }
        return ans;
    }
}