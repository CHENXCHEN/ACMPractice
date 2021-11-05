package leetcode.normal.j367;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/valid-perfect-square/
 * 367. 有效的完全平方数
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (left + right) >> 1;
            long tmp = mid * mid;
            if (tmp == num) return true;
            else if (tmp < num) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}