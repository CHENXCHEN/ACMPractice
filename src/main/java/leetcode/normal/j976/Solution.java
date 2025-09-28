package leetcode.normal.j976;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-perimeter-triangle/description/">976. 三角形的最大周长</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        // 枚举最长边，因为 a <= b <= c，需要满足 a + b > c，才可以使得三条边能组成三角形
        // 对于确定的 c，找最大的 a b，看能否组成
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}