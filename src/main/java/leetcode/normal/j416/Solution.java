package leetcode.normal.j416;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">416. 分割等和子集</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0, maxNum = 0;
        if (n < 2) return false;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        if (maxNum > target) return false;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }
}