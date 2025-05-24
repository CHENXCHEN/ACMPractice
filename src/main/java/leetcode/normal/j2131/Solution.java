package leetcode.normal.j2131;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-palindrome-by-concatenating-two-letter-words/description/">2131. 连接两字母单词得到的最长回文串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (cnt.containsKey(reversed)) {
                ans += 4;
                cnt.compute(reversed, (k, v) -> v == 1 ? null : (v - 1));
            } else {
                cnt.compute(word, (k, v) -> v == null ? 1 : (v + 1));
            }
        }
        int maxOddCnt = 0;
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            String key = entry.getKey();
            if (key.charAt(0) == key.charAt(1)) {
                maxOddCnt = Math.max(maxOddCnt, entry.getValue());
            }
        }
        return ans + (maxOddCnt << 1);
    }
}