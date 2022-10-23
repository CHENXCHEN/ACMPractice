package leetcode.normal.j1768;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-strings-alternately/">1768. 交替合并字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) sb.append(word1.charAt(i));
            if (i < word2.length()) sb.append(word2.charAt(i));
            ++i;
        }
        return sb.toString();
    }
}