package leetcode.normal.j724;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-pivot-index/description/">724. 寻找数组的中心下标</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) res += nums[i - 1];
            if (sum - nums[i] - res == res) return i;
        }
        return -1;
    }
}