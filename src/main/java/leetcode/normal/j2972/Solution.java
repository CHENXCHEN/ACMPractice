package leetcode.normal.j2972;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-ii/description/">2972. 统计移除递增子数组的数目 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int leftPos = 0, rightPos = n - 1;
        while (leftPos + 1 < n && nums[leftPos] < nums[leftPos + 1]) ++leftPos;
        while (rightPos - 1 >= 0 && nums[rightPos] > nums[rightPos - 1]) --rightPos;
        // nums[leftPos] >= nums[leftPos + 1]
        // nums[rightPos - 1] >= nums[rightPos]
        // 假设可以删除 [x,y]
        // 那么 x 应该位于 [0, leftPos + 1]
        // 那么 y 应该位于 [rightPos - 1, n - 1]
        long ans = 0;
        int x = 0, y = rightPos - 1;
        while (x <= leftPos + 1) {
            while (x > 0 && y + 1 < n && nums[x - 1] >= nums[y + 1]) ++y;
            if (y >= 0) ans += n - y;
            ++x;
        }
        return ans;
    }
}