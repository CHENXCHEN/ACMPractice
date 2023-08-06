package leetcode.normal.j344;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reverse-string/">344. 反转字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[right];
            s[right] = s[left];
            s[left] = tmp;
            ++left;
            --right;
        }
    }
}