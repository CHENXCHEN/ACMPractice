package leetcode.normal.j1048;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-string-chain/">1048. 最长字符串链</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int n;

    public int longestStrChain(String[] words) {
        n = words.length;
        Arrays.sort(words, (x, y) -> x.length() - y.length());
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (check(words[i], words[j])) {
                    vis[i][j] = true;
                }
            }
        }
        int ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (vis[j][i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    boolean check(String a, String b) {
        if (Math.abs(a.length() - b.length()) != 1) return false;
        int[] idx1 = {0, a.length() - 1}, idx2 = {0, b.length() - 1};
        while (idx1[0] <= idx1[1] && idx2[0] <= idx2[1]) {
            if (a.charAt(idx1[0]) == b.charAt(idx2[0])) {
                idx1[0]++;
                idx2[0]++;
            } else if (a.charAt(idx1[1]) == b.charAt(idx2[1])) {
                idx1[1]--;
                idx2[1]--;
            } else {
                return false;
            }
        }
        return true;
    }
}