package leetcode.normal.j186;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string-ii/description/">186. 反转字符串中的单词 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void reverseWords(char[] s) {
        // 先将整个字符串反序，再将每个单词反序
        reverse(s, 0, s.length - 1);
        int left = 0;
        while (left < s.length) {
            int right = left + 1;
            while (right < s.length && s[right] != ' ') {
                right++;
            }
            reverse(s, left, right - 1);
            left = right + 1;
        }
    }

    void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}