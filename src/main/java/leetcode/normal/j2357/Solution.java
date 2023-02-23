package leetcode.normal.j2357;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/">2357. 使数组中所有元素都等于零</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumOperations(int[] nums) {
        int last = 0, ans = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num != last) {
                ++ans;
                last = num;
            }
        }
        return ans;
    }
}