package leetcode.normal.j541;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * 541. 反转字符串 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        int step = k << 1;
        for (int i = 0; i < len; i += step) {
            int start = i;
            int end = Math.min(start + k - 1, len - 1);
            while (end >= i) {
                sb.setCharAt(start, s.charAt(end));
                end -= 1;
                start += 1;
            }
        }
        return sb.toString();
    }
}