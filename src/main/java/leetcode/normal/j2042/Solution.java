package leetcode.normal.j2042;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/check-if-numbers-are-ascending-in-a-sentence/">2042. 检查句子中的数字是否递增</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean areNumbersAscending(String s) {
        int last = -1, i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') ++i;
            int tmp = 0;
            boolean isNumber = true;
            while (i < s.length() && s.charAt(i) != ' ') {
                isNumber = isNumber & Character.isDigit(s.charAt(i));
                if (isNumber) tmp += tmp * 10 + s.charAt(i) - '0';
                ++i;
            }
            if (isNumber) {
                if (last >= tmp) return false;
                last = tmp;
            }
        }
        return true;
    }
}