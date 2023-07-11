package leetcode.normal.j1911;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-alternating-subsequence-sum/">1911. 最大子序列交替和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxAlternatingSum(int[] nums) {
        // dp[0] -> 表示到当前为止以偶数结尾的最大交替和是多少
        // dp[1] -> 表示到当前为止以奇数结尾的最大交替和是多少
        long[] dp = {nums[0], 0};
        for (int i = 1; i < nums.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + nums[i]);
            dp[1] = Math.max(dp[1], dp[0] - nums[i]);
        }
        return dp[0];
    }
}