package leetcode.normal.j268;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/missing-number/
 * 268. 丢失的数字
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int missingNumber(int[] nums) {
        int ss = (nums.length * (nums.length + 1)) >> 1;
        for (int num : nums) {
            ss -= num;
        }
        return ss;
    }
}
