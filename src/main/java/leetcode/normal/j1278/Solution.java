package leetcode.normal.j1278;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/palindrome-partitioning-iii/description/">1278. 分割回文串 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        // dp[i][j] 表示将 s 的前 i 个字符，分割为 j 个不相交的回文串，所需要的最少消耗是多少
        // 枚举最后一个回文串的情况消耗
        // dp[i][j] = min(dp[i'][j-1] + cost(s[i',i-1])), j - 1 <= i' < i
        // dp[i][1] = cost(s[0,i-1])
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE >> 1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(k, i); j++) {
                if (j == 1) dp[i][j] = cost(s, 0, i - 1);
                else {
                    for (int i0 = j - 1; i0 < i; i0++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i0][j - 1] + cost(s, i0, i - 1));
                    }
                }
            }
        }
        return dp[n][k];
    }

    int cost(String s, int start, int end) {
        int ans = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) ++ans;
            ++start;
            --end;
        }
        return ans;
    }
}