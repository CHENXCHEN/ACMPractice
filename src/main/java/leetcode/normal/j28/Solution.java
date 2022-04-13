package leetcode.normal.j28;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/implement-strstr/
 * 28. 实现 strStr()
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        genNext(needle, next);
        for (int i = 0, j = -1; i < haystack.length(); i++) {
            while (j > -1 && needle.charAt(j + 1) != haystack.charAt(i)) j = next[j];
            if (needle.charAt(j + 1) == haystack.charAt(i)) j++;
            if (j == needle.length() - 1) {
                return i - j;
            }
        }
        return -1;
    }

    void genNext(String str, int[] next) {
        next[0] = -1;
        for (int i = 1, j = -1; i < str.length(); i++) {
            while (j > -1 && str.charAt(j + 1) != str.charAt(i)) j = next[j];
            if (str.charAt(j + 1) == str.charAt(i)) j++;
            next[i] = j;
        }
    }
}