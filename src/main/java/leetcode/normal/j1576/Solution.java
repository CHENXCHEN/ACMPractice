package leetcode.normal.j1576;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 * 1576. 替换所有的问号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    boolean isPlace(StringBuilder s, int pos, char ch) {
        if (pos == 0) {
            return s.length() <= 1 || s.charAt(1) != ch;
        } else if (pos == s.length() - 1) {
            return s.length() <= 1 || s.charAt(pos - 1) != ch;
        } else {
            return s.charAt(pos - 1) != ch && s.charAt(pos + 1) != ch;
        }
    }

    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                for (int j = 0; j < 26; j++) {
                    char ch = (char) ('a' + j);
                    if (isPlace(sb, i, ch)) {
                        sb.setCharAt(i, ch);
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}