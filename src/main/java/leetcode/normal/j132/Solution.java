package leetcode.normal.j132;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-ii/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] checked = new boolean[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(checked[i], true);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                checked[i][j] = s.charAt(i) == s.charAt(j) && checked[i + 1][j - 1];
            }
        }
        // dp[i] 表示 [0..i] 可以最少切割为多少次，使得每个部分都是回文串
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE >> 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (checked[0][i]) dp[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (checked[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}