package leetcode.normal.j2734;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/description/">2734. 执行子串操作后的字典序最小字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String smallestString(String s) {
        int left = 0, right = 0;
        while (left < s.length() && s.charAt(left) == 'a') left++;
        right = left;
        while (right < s.length() && s.charAt(right) != 'a') right++;
        StringBuilder sb = new StringBuilder(s);
        if (left == right) {
            sb.setCharAt(right - 1, 'z');
        } else {
            for (int i = left; i < right; i++) {
                sb.setCharAt(i, (char) (s.charAt(i) - 1));
            }
        }
        return sb.toString();
    }
}