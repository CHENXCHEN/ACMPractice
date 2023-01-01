package leetcode.normal.j2351;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/first-letter-to-appear-twice/">2351. 第一个出现两次的字母</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public char repeatedCharacter(String s) {
        int mark = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (((mark >> ch) & 1) == 1) {
                return s.charAt(i);
            }
            mark |= 1 << ch;
        }
        return 'a';
    }
}