package leetcode.normal.j377;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/combination-sum-iv/description/">377. 组合总和 Ⅳ</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}