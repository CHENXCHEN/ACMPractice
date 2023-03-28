package leetcode.normal.j1092;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-common-supersequence/">1092. 最短公共超序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        // dp[i][j] 表示为 str1[i..n] 和 str2[j..n] 的最短长度
        // 考虑边界情况：
        // dp[i][m] = n - i，当第二个字符串是空串，那么第一个字符串从 i 开始的后缀则为最短的长度
        // dp[n][i] = m - i，当第一个字符串是空串，那么第二个字符串从 i 开始的后缀则为最短的长度
        // 当 str[i] == str[j] 时，dp[i][j] = dp[i+1][j+1] + 1，因为最短的字符串要加上当前的字符肯定是最优的
        // 否则 dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1]) + 1，因为最短的字符串要么选 str1[i]，要么选 str2[j]，取决于选哪个的长度最短
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][m] = n - i;
        }
        for (int i = 0; i < m; i++) {
            dp[n][i] = m - i;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) dp[i][j] = dp[i + 1][j + 1] + 1;
                else dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
            }
        }
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        // 从 dp[0][0] 开始倒推，每一步应该选哪个字符
        while (p1 < n && p2 < m) {
            if (str1.charAt(p1) == str2.charAt(p2)) {
                sb.append(str1.charAt(p1));
                p1++;
                p2++;
            } else if (dp[p1][p2] == dp[p1 + 1][p2] + 1) {
                sb.append(str1.charAt(p1));
                p1++;
            } else if (dp[p1][p2] == dp[p1][p2 + 1] + 1) {
                sb.append(str2.charAt(p2));
                p2++;
            }
        }
        if (p1 < n) {
            sb.append(str1.substring(p1));
        } else if (p2 < m) {
            sb.append(str2.substring(p2));
        }
        return sb.toString();
    }
}