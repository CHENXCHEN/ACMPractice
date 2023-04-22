package leetcode.normal.j1027;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/">1027. 最长等差数列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestArithSeqLength(int[] nums) {
        // dp[i][j] 表示为到 nums[i] 为止，等差为 j 的最长长度是多少，答案为 max(dp[i][j])
        int ans = 0;
        int[][] dp = new int[nums.length][1002];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
                ans = Math.max(dp[i][diff], ans);
            }
        }
        return ans;
    }
}