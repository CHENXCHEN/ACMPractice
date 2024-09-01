package leetcode.normal.j459;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/repeated-substring-pattern/description/">459. 重复的子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}