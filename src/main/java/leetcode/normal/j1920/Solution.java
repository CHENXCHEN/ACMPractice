package leetcode.normal.j1920;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/build-array-from-permutation/description/">1920. 基于排列构建数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}