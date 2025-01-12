package leetcode.normal.j2270;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-ways-to-split-array/description/">2270. 分割数组的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0, leftSum = 0;
        int ans = 0;
        for (int num : nums) sum += num;
        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            // leftSum >= sum - leftSum
            if ((leftSum << 1) >= sum) {
                ans++;
            }
        }
        return ans;
    }
}