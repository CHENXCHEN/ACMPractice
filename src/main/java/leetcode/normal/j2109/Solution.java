package leetcode.normal.j2109;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/adding-spaces-to-a-string/description/">2109. 向字符串添加空格</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(' ');
                ++j;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}