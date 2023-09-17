package leetcode.normal.j213;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/house-robber-ii/description/">213. 打家劫舍 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(calc(nums, 0, nums.length - 1), calc(nums, 1, nums.length));
    }

    int calc(int[] nums, int start, int end) {
        int pre = nums[start], cur = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            int next = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = next;
        }
        return cur;
    }
}