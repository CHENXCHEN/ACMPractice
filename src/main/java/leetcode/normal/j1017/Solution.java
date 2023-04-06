package leetcode.normal.j1017;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-to-base-2/">1017. 负二进制转换</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) return String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int r = n & 1;
            sb.append(r);
            n -= r;
            n /= -2;
        }
        return sb.reverse().toString();
    }
}