package leetcode.normal.j410;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/split-array-largest-sum/description/">410. 分割数组的最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        // dp[i] -> 表示到当前分割了 x 次之后，前缀数组 nums[0],...,nums[i] 的最大值是多少
        int[] dp = new int[n];
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
//        System.out.println("preSum: " + Arrays.toString(preSum));
        // 计算只有 1 个子数组的情况
        for (int i = 0; i < n; i++) {
            dp[i] = preSum[i + 1];
        }
        for (int x = 1; x < k; x++) {
            for (int i = n - 1; i >= x; i--) {
                int res = Integer.MAX_VALUE;
                for (int j = i; j >= x; j--) {
                    res = Math.min(res, Math.max(dp[j - 1], preSum[i + 1] - preSum[j]));
                }
                dp[i] = res;
            }
//            System.out.println("x: " + x + " dp: " + Arrays.toString(dp));
        }
        return dp[n - 1];
    }
}