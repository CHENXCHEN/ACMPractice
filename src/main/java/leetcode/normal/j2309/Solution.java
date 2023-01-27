package leetcode.normal.j2309;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/">2309. 兼具大小写的最好英文字母</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String greatestLetter(String s) {
        char[] mark = new char[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) mark[ch - 'a'] |= 1;
            else mark[ch - 'A'] |= 2;
        }
        for (int i = 25; i >= 0; i--) {
            if (mark[i] == 3) return String.valueOf((char) ('A' + i));
        }
        return "";
    }
}