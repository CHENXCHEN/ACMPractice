package leetcode.normal.j2786;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/visit-array-positions-to-maximize-score/description/">2786. 访问数组中的位置使分数最大</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[] dp = new long[2];
        dp[0] = dp[1] = Integer.MIN_VALUE;
        dp[nums[0] & 1] = nums[0];
        for (int i = 1; i < n; i++) {
            int party = nums[i] & 1;
            long cur = Math.max(dp[party] + nums[i], dp[1 - party] + nums[i] - x);
            dp[party] = Math.max(dp[party], cur);
        }
        return Math.max(dp[0], dp[1]);
    }
}