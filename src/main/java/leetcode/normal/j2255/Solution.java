package leetcode.normal.j2255;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-prefixes-of-a-given-string/description/">2255. 统计是给定字符串前缀的字符串数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }
        return ans;
    }
}