package leetcode.normal.j342;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/power-of-four/
 * 342. 4的幂
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n != 1 && (n & 3) == 0) {
            n >>= 2;
        }
        return n == 1;
    }
}