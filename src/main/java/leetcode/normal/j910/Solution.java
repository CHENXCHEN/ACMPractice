package leetcode.normal.j910;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/smallest-range-ii/description/">910. 最小差值 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0], max = nums[nums.length - 1];
        int ans = max - min;
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            ans = Math.min(ans, Math.max(max - k, a + k) - Math.min(min + k, b - k));
        }
        return ans;
    }
}