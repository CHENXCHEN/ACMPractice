package leetcode.normal.j1790;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/">1790. 仅执行一次字符串交换能否使两个字符串相等</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int pos = -1;
        int cnt = 0, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++cnt;
                if (cnt == 1) pos = i;
                else if (cnt == 2 && s1.charAt(i) == s2.charAt(pos) && s1.charAt(pos) == s2.charAt(i)) {
                } else return false;
            }
        }
        return cnt == 0 || cnt == 2;
    }
}