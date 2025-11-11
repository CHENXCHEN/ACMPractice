package leetcode.normal.j474;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ones-and-zeroes/description/">474. 一和零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 表示 i 个 0，j 个 1 的最大子集数
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int cnt0 = 0, cnt1 = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') ++cnt0;
                else ++cnt1;
            }
            for (int i = m; i - cnt0 >= 0; i--) {
                for (int j = n; j - cnt1 >= 0; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - cnt0][j - cnt1] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}