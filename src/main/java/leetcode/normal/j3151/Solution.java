package leetcode.normal.j3151;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/special-array-i/description/">3151. 特殊数组 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int last = nums[0] & 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i] & 1;
            if (cur == last) return false;
            last = cur;
        }
        return true;
    }
}