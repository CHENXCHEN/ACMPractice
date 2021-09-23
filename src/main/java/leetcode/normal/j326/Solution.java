package leetcode.normal.j326;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/power-of-three/
 * 326. 3的幂
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isPowerOfThree(int n) {
        while (n > 0 && n % 3 == 0) {
            n /= 3;
        }
        return n > 0 && (n == 1 || n % 3 == 0);
    }
}