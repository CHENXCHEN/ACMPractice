package leetcode.normal.j3330;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-original-typed-string-i/description/">3330. 找到初始输入字符串 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int possibleStringCount(String word) {
        int ans = 0, i = 0;
        while (i < word.length()) {
            int j = i + 1;
            while (j < word.length() && word.charAt(i) == word.charAt(j)) j++;
            if (j - i > 1) ans += j - i - 1;
            i = j;
        }
        return ans + 1;
    }
}