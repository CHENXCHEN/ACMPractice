package leetcode.normal.j2154;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/keep-multiplying-found-values-by-two/description/">2154. 将找到的值乘以 2</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original <<= 1;
            }
        }
        return original;
    }
}