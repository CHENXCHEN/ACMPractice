package leetcode.normal.j730;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/count-different-palindromic-subsequences/
 * 730. 统计不同回文子序列
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][] dp = new int[n][n], next = new int[n][4], pre = new int[n][4];
        int[] pos = new int[4];
        int mod = 1000000000 + 7;
        Arrays.fill(pos, -1);
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            System.arraycopy(pos, 0, pre[i], 0, 4);
            pos[s.charAt(i) - 'a'] = i;
        }
        Arrays.fill(pos, n);
        for (int i = n - 1; i >= 0; i--) {
            System.arraycopy(pos, 0, next[i], 0, 4);
            pos[s.charAt(i) - 'a'] = i;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int nextI = next[i][s.charAt(i) - 'a'];
                    int preJ = pre[j][s.charAt(j) - 'a'];
                    if (nextI == preJ) {
                        dp[i][j] = (1 + (dp[i + 1][j - 1] << 1)) % mod;
                    } else if (nextI > preJ) {
                        dp[i][j] = (2 + (dp[i + 1][j - 1] << 1)) % mod;
                    } else {
                        dp[i][j] = ((dp[i + 1][j - 1] << 1) % mod - dp[nextI + 1][preJ - 1] + mod) % mod;
                    }
                } else {
                    dp[i][j] = ((dp[i][j - 1] + dp[i + 1][j]) % mod - dp[i + 1][j - 1] + mod) % mod;
                }
            }
        }
        return dp[0][n - 1];
    }
}