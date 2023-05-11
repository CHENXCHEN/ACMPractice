package leetcode.normal.j1016;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/">1016. 子串能表示从 1 到 N 数字的二进制串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String s1 = Integer.toBinaryString(i);
            if (!s.contains(s1)) return false;
        }
        return true;
    }
}