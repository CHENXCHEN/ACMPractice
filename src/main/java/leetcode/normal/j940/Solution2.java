package leetcode.normal.j940;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/distinct-subsequences-ii/">940. 不同的子序列 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int distinctSubseqII(String s) {
        int mod = (int) (1e9 + 7);
        int n = s.length(), tot = 0;
        int[] dp = new int[26];
        for (int i = 0; i < n; i++) {
            int k = s.charAt(i) - 'a';
            int pre = dp[k];
            dp[k] = (tot + 1) % mod;
            tot = ((tot + dp[k] - pre) % mod + mod) % mod;
        }
        return tot;
    }
}