package leetcode.normal.j2535;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/">2535. 数组元素和与数字和的绝对差</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int differenceOfSum(int[] nums) {
        int s1 = 0, s2 = 0;
        for (int num : nums) {
            s1 += num;
            while (num > 0) {
                s2 += num % 10;
                num /= 10;
            }
        }
        return Math.abs(s1 - s2);
    }
}