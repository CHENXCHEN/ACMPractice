package leetcode.normal.j2970;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-incremovable-subarrays-i/description/">2970. 统计移除递增子数组的数目 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int leftPos = 0, rightPos = n - 1;
        while (leftPos + 1 < n && nums[leftPos] < nums[leftPos + 1]) ++leftPos;
        while (rightPos - 1 >= 0 && nums[rightPos] > nums[rightPos - 1]) --rightPos;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0 && j == n - 1) ++ans;
                else if (i == 0) {
                    if (j >= rightPos - 1) ++ans;
                } else if (j == n - 1) {
                    if (i <= leftPos + 1) ++ans;
                } else if (i <= leftPos + 1 && j >= rightPos - 1 && nums[j + 1] > nums[i - 1]) ++ans;
//                System.out.println(String.format("(%d,%d): %d", i, j, ans));
            }
        }
        return ans;
    }
}