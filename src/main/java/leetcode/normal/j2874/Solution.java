package leetcode.normal.j2874;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/description/">2874. 有序三元组中的最大值 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
        }
        long ans = 0, leftMax = nums[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, (long) (leftMax - nums[i]) * rightMax[i + 1]);
            leftMax = Math.max(leftMax, nums[i]);
        }
        return ans;
    }
}