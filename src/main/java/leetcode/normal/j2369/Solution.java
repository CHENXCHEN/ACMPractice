package leetcode.normal.j2369;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/description/">2369. 检查数组是否存在有效划分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        // dp[i] => 长度为 i 的前缀子数组是否是一个合法划分
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (i >= 2) {
                dp[i] = dp[i - 2] & valid2(nums[i - 2], nums[i - 1]);
            }
            if (i >= 3) {
                dp[i] |= dp[i - 3] && valid3(nums[i - 3], nums[i - 2], nums[i - 1]);
            }
        }
        return dp[n];
    }

    boolean valid2(int a, int b) {
        return a == b;
    }

    boolean valid3(int a, int b, int c) {
        return (valid2(a, b) && valid2(b, c)) || (c - b == 1 && b - a == 1);
    }
}