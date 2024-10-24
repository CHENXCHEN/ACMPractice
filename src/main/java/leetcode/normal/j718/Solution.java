package leetcode.normal.j718;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/">718. 最长重复子数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // dp[i][j] => 以 nums1[0...i], nums2[0...j] 结尾的最长公共连续子数组长度
        // 若 nums[i] = nums[j]，则 dp[i][j] = dp[i-1][j-1] + 1，否则 dp[i][j] = 0
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return ans;
    }
}