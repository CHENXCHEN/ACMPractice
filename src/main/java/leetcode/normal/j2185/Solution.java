package leetcode.normal.j2185;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/counting-words-with-a-given-prefix/">2185. 统计包含给定前缀的字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref)) ++cnt;
        }
        return cnt;
    }
}