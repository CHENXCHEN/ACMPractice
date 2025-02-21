package leetcode.normal.j2506;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-of-similar-strings/description/">2506. 统计相似字符串对的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.compute(calcWord(word), (k, v) -> v == null ? 1 : v + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > 1) {
                ans += (entry.getValue() - 1) * entry.getValue() / 2;
            }
        }
        return ans;
    }

    int calcWord(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res |= (1 << (word.charAt(i) - 'a'));
        }
        return res;
    }
}