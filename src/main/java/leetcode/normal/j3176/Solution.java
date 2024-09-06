package leetcode.normal.j3176;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/">3176. 求出最长好子序列 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumLength(int[] nums, int limit) {
        int n = nums.length;
        // dp[i][j] -> 以 i 为最后一个元素的子序列最长长度，序列中有 j 个相邻不相等的元素
        // 若 nums[i] = nums[k]，则 dp[i][j] = max(dp[k][j]) + 1
        // 若 nums[i] != nums[k]，则 dp[i][j] = max(dp[k][j-1]) + 1
        int[][] dp = new int[n][limit + 1];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            for (int k = i - 1; k >= 0; k--) {
                for (int j = 0; j <= limit; j++) {
                    if (nums[i] == nums[k]) {
                        if (dp[k][j] != -1)
                            dp[i][j] = Math.max(dp[i][j], dp[k][j] + 1);
                    } else {
                        if (j > 0 && dp[k][j - 1] != -1)
                            dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + 1);
                    }
                }
            }
            if (dp[i][0] == -1) dp[i][0] = 1;
            for (int j = 0; j <= limit; j++)
                ans = Math.max(ans, dp[i][j]);
        }
        return ans;
    }
}