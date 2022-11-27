package leetcode.normal.j1752;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/">1752. 检查数组是否经排序和轮转得到</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean check(int[] nums) {
        int i = 1, minNum = nums[0];
        while (i < nums.length && nums[i] >= nums[i - 1]) {
            minNum = Math.min(nums[i], minNum);
            i++;
        }
        if (i == nums.length - 1) {
            return nums[i] <= minNum;
        }
        ++i;
        while (i < nums.length && nums[i] >= nums[i - 1] && nums[i] <= minNum) i++;
        return i >= nums.length;
    }
}