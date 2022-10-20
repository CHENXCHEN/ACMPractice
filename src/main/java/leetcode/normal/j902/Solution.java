package leetcode.normal.j902;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/">902. 最大为 N 的数字组合</a>
 * dp[i][0] 表示前 i 位小于 n 的数字个数，dp[i][1] 表示前 i 位等于 n 的数字个数，dp[i][1] 要么为 1，要么为 0
 * 若 digit[i] == s[i]，那么 dp[i][1] = dp[i-1][1];
 * 若 digit[i] < s[i], 那么 dp[i][0] += dp[i-1][1];
 * 若 i > 1，那么 dp[i][0] += m + dp[i-1][0] * m;
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int m = digits.length, k = s.length();
        int[][] dp = new int[k + 1][2];
        dp[0][1] = 1;
        for (int i = 1; i <= k; i++) {
            for (String digit : digits) {
                if (digit.charAt(0) < s.charAt(i - 1)) {
                    dp[i][0] += dp[i - 1][1];
                } else if (digit.charAt(0) == s.charAt(i - 1)) {
                    dp[i][1] = dp[i - 1][1];
                } else break;
            }
            if (i > 1) dp[i][0] += m + dp[i - 1][0] * m;
        }
        return dp[k][0] + dp[k][1];
    }
}