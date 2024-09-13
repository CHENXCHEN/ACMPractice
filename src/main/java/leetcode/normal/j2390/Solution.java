package leetcode.normal.j2390;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/removing-stars-from-a-string/description/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                sb.delete(sb.length() - 1, sb.length());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}