package leetcode.normal.j2595;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-even-and-odd-bits/description/">2595. 奇偶位数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans[i % 2]++;
            }
            i++;
            n >>= 1;
        }
        return ans;
    }
}