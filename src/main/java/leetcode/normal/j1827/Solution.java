package leetcode.normal.j1827;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/">1827. 最少操作使数组递增</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(int[] nums) {
        int ans = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= pre) {
                ans += pre - nums[i] + 1;
                pre++;
            } else pre = nums[i];
        }
        return ans;
    }
}