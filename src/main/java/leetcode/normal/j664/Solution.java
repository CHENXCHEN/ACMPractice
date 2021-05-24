package leetcode.normal.j664;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/strange-printer/submissions/
 * 664. 奇怪的打印机
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int mm = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) mm = Math.min(mm, dp[i][k] + dp[k + 1][j]);
                    dp[i][j] = mm;
                }
            }
        }
        return dp[0][n - 1];
    }
}
