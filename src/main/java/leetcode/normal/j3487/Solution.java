package leetcode.normal.j3487;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-unique-subarray-sum-after-deletion/description/">3487. 删除后的最大子数组元素和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSum(int[] nums) {
        int[] last = new int[101];
        int ans = 0, neg = Integer.MIN_VALUE;
        boolean check = false;
        Arrays.fill(last, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && last[nums[i]] == -1) {
                ans += nums[i];
                last[nums[i]] = 1;
                check = true;
            }
            if (nums[i] < 0) {
                neg = Math.max(neg, nums[i]);
            }
        }
        return check ? ans : neg;
    }
}