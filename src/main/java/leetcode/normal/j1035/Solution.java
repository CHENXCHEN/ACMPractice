package leetcode.normal.j1035;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/uncrossed-lines/description/">1035. 不相交的线</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // nums1[0:i] => nums1 中长度为 i 的前缀
        // dp[i][j] => nums1[0:i] 以及 nums2[0:j] 时最长公共子序列的长度
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}