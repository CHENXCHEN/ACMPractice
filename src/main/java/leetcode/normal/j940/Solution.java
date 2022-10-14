package leetcode.normal.j940;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distinct-subsequences-ii/">940. 不同的子序列 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int) (1e9 + 7);
        int n = s.length();
        int[] dp = new int[n], last = new int[26];
        Arrays.fill(last, -1);
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    dp[i] = (dp[i] + dp[last[j]]) % mod;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) ans = (ans + dp[last[i]]) % mod;
        }
        return ans;
    }
}