package leetcode.normal.j1664;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/ways-to-make-a-fair-array/">1664. 生成平衡数组的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] leftSum = new int[nums.length], rightSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            leftSum[i] = (i - 2 >= 0 ? leftSum[i - 2] : 0) + nums[i];
        for (int i = nums.length - 1; i >= 0; i--)
            rightSum[i] = (i + 2 < nums.length ? rightSum[i + 2] : 0) + nums[i];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] left = {i - 2 >= 0 ? leftSum[i - 2] : 0, i - 1 >= 0 ? leftSum[i - 1] : 0};
            int[] right = {i + 1 < nums.length ? rightSum[i + 1] : 0, i + 2 < nums.length ? rightSum[i + 2] : 0};
            if (left[1] + right[1] == left[0] + right[0]) ans++;
        }
        return ans;
    }
}