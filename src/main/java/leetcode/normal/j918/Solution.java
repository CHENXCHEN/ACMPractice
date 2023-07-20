package leetcode.normal.j918;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-sum-circular-subarray/">918. 环形子数组的最大和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // 分类讨论，如果选择的起始坐标为 0<=i<j<n，那么有
        // 选择 i -> j，传统做法，如果加起来是正数有贡献，那么就继续加下去
        // 选择 [0,i] & [j,n-1]，枚举 j，去找 i 的最大值
        int ans = nums[0], pre = nums[0], leftsum = nums[0], n = nums.length;
        int[] leftMax = new int[n];
        leftMax[0] = leftsum;
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
            leftsum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftsum);
        }
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            ans = Math.max(ans, leftMax[i - 1] + rightSum);
        }
        return ans;
    }
}