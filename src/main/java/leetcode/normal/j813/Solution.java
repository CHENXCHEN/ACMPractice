package leetcode.normal.j813;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-sum-of-averages/">813. 最大平均值和的分组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        // dp[i][j] 为取到第 i 个元素时，分组为 j 时的最大值 (i >= j)
        double[][] dp = new double[n + 1][k + 1];
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            dp[i + 1][1] = 1.0 * preSum[i + 1] / (i + 1);
        }
        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= n; i++) {
                for (int x = j - 1; x < i; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + 1.0 * (preSum[i] - preSum[x]) / (i - x));
                }
            }
        }
        return dp[n][k];
    }
}