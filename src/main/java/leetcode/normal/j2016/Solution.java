package leetcode.normal.j2016;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-difference-between-increasing-elements/">2016. 增量元素之间的最大差值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1, min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                ans = Math.max(ans, nums[i] - min);
            }
            min = Math.min(min, nums[i]);
        }
        return ans;
    }
}