package leetcode.normal.j2696;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-string-length-after-removing-substrings/description/">2696. 删除子串后的字符串最小长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minLength(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sb.length() > 0 && ((sb.charAt(sb.length() - 1) == 'A' && ch == 'B') || (sb.charAt(sb.length() - 1) == 'C' && ch == 'D'))) {
                sb.delete(sb.length() - 1, sb.length());
            } else {
                sb.append(ch);
            }
        }
        return sb.length();
    }
}