package leetcode.normal.j66;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/plus-one/
 * 66. 加一
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i] -= 10;
                digits[i - 1] += 1;
            } else break;
        }
        if (digits[0] >= 10) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            digits[0] -= 10;
            System.arraycopy(digits, 0, ints, 1, digits.length);
            return ints;
        } else return digits;
    }
}