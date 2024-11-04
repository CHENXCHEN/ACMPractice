package leetcode.normal.j633;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-square-numbers/description/">633. 平方数之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            long target = left * left + right * right;
            if (target == c) {
                return true;
            } else if (target > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}