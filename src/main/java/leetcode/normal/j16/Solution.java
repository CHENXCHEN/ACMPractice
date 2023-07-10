package leetcode.normal.j16;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/3sum-closest/">16. 最接近的三数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int lastSum = nums[0] + nums[1] + nums[2], n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int ss = nums[i] + nums[left] + nums[right];
                if (ss < target) {
                    left++;
                } else if (ss > target) {
                    right--;
                } else {
                    return ss;
                }
                if (Math.abs(target - ss) < Math.abs(target - lastSum)) {
                    lastSum = ss;
                }
            }
        }
        return lastSum;
    }
}