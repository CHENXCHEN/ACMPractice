package leetcode.normal.j2085;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-common-words-with-one-occurrence/description/">2085. 统计出现过一次的公共字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> cnt1 = new HashMap<>(), cnt2 = new HashMap<>();
        for (String s : words1) {
            cnt1.compute(s, (k, v) -> (v == null ? 0 : v) + 1);
        }
        for (String s : words2) {
            cnt2.compute(s, (k, v) -> (v == null ? 0 : v) + 1);
        }
        int ans = 0;
        for (String s : cnt1.keySet()) {
            if (cnt1.get(s) == 1 && cnt2.getOrDefault(s, 0) == 1) {
                ++ans;
            }
        }
        return ans;
    }
}