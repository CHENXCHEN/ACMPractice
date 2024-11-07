package leetcode.normal.j3255;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-ii/description/">3255. 长度为 K 的子数组的能量值 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) pre[i] = pre[i - 1] + 1;
            else pre[i] = 1;
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = pre[i + k - 1] >= k ? nums[i + k - 1] : -1;
        }
        return result;
    }
}