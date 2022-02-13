package leetcode.normal.j1984;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * 1984. 学生分数的最小差值
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[k - 1] - nums[0];
        for (int i = 0; i <= nums.length - k; i++) {
            ans = Math.min(ans, nums[i + k - 1] - nums[i]);
        }
        return ans;
    }
}
