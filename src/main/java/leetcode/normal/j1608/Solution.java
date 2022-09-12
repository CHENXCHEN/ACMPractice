package leetcode.normal.j1608;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/">1608. 特殊数组的特征值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (nums[n - i] >= i) {
                if (i == n || nums[n - i - 1] < i) {
                    return i;
                }
            }
        }
        return -1;
    }
}