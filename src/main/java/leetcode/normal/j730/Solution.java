package leetcode.normal.j730;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/count-different-palindromic-subsequences/
 * 730. 统计不同回文子序列
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][][] dp = new int[4][n][n];
        int mod = 1000000000 + 7;
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i + len - 1 < s.length(); i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[s.charAt(i) - 'a'][i][i] = 1;
                } else {
                    for (int k = 0; k < 4; k++) {
                        char ch = (char) ('a' + k);
                        if (s.charAt(i) == ch && s.charAt(j) == ch) {
                            for (int x = 0; x < 4; x++) {
                                dp[k][i][j] += dp[x][i + 1][j - 1];
                                dp[k][i][j] %= mod;
                            }
                            dp[k][i][j] += 2;
                        } else if (s.charAt(i) == ch) {
                            dp[k][i][j] = dp[k][i][j - 1];
                        } else if (s.charAt(j) == ch) {
                            dp[k][i][j] = dp[k][i + 1][j];
                        } else {
                            dp[k][i][j] = dp[k][i + 1][j - 1];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) ans = (ans + dp[i][0][n - 1]) % mod;
        return ans;
    }
}