package leetcode.normal.j189;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/rotate-array/description/">189. 轮转数组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] temp = Arrays.copyOf(nums, n);
        // nums[i] = nums[i-k]
        for (int i = 0; i < n; i++) {
            nums[i] = temp[(i - k + n) % n];
        }
    }
}