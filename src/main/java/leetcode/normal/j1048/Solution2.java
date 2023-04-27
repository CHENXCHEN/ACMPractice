package leetcode.normal.j1048;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-string-chain/">1048. 最长字符串链</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (String word : words) {
            int cur = map.getOrDefault(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                Integer cnt = map.get(prev);
                if (cnt != null) {
                    cur = Math.max(cur, cnt + 1);
                }
            }
            map.put(word, cur);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}