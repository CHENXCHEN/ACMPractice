package leetcode.normal.j3024;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/type-of-triangle/description/">3024. 三角形类型</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] + nums[1] <= nums[2]) return "none";
        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] == nums[1] || nums[1] == nums[2]) {
            return "isosceles";
        }
        return "scalene";
    }
}