package leetcode.normal.j260;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/single-number-iii/
 * 260. 只出现一次的数字 III
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int twoXor = 0;
        for (int num : nums) {
            twoXor ^= num;
        }
        int minBit = twoXor & -twoXor;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & minBit) != 0) {
                num1 ^= num;
            } else num2 ^= num;
        }
        return new int[]{num1, num2};
    }
}
