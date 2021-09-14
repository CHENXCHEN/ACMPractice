package leetcode.normal.j524;

import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 524. 通过删除字母匹配到字典里最长单词
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        int len = s.length();
        int[][] dp = new int[len + 1][26];
        Arrays.fill(dp[len], len);
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == (char) ('a' + j)) {
                    dp[i][j] = i;
                } else dp[i][j] = dp[i + 1][j];
            }
        }
        int ans = -1;
        for (int idx = 0; idx < dictionary.size(); idx++) {
            int j = 0;
            boolean isMatch = true;
            String t = dictionary.get(idx);
            int lenT = t.length();
            for (int i = 0; i < lenT; i++) {
                if (dp[j][t.charAt(i) - 'a'] == len) {
                    isMatch = false;
                    break;
                } else j = dp[j][t.charAt(i) - 'a'] + 1;
            }
            if (isMatch) {
                if(ans == -1) ans = idx;
                else if (dictionary.get(ans).length() < lenT || (dictionary.get(ans).length() == lenT && t.compareTo(dictionary.get(ans)) < 0)) {
                    ans = idx;
                }
            }
        }
        if (ans == -1) return "";
        else return dictionary.get(ans);
    }
}