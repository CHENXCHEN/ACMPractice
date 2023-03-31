package leetcode.normal.j2367;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-arithmetic-triplets/">2367. 算术三元组的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = Arrays.binarySearch(nums, diff + nums[i]);
            if (j > i && j < nums.length && nums[j] - nums[i] == diff) {
                int k = Arrays.binarySearch(nums, diff + nums[j]);
                if (k > j && k < nums.length && nums[k] - nums[j] == diff) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}