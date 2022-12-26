package leetcode.normal.j1759;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-homogenous-substrings/">1759. 统计同构子字符串的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countHomogenous(String s) {
        int i = 0;
        int mod = 1000000000 + 7;
        long ans = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int tmp = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                ++i;
                ++tmp;
            }
            ans += ((1L + tmp) * tmp) >> 1;
        }
        return (int) (ans % mod);
    }
}