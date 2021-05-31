package leetcode.normal.j231;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/power-of-two/
 * 231. 2 的幂
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n != 0 && n != Integer.MIN_VALUE && (n & (n - 1)) == 0;
    }
}
