package leetcode.normal.j1657;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/description/">1657. 确定两个字符串是否接近</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int n = word1.length(), mask1 = 0, mask2 = 0;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        HashMap<Integer, Integer> tMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] > 0) mask1 |= 1 << i;
            if (cnt2[i] > 0) mask2 |= 1 << i;
            tMap.compute(cnt1[i], (k, v) -> (v == null ? 0 : v) + 1);
            tMap.compute(cnt2[i], (k, v) -> (v == null ? 0 : v) - 1);
        }
        long count = tMap.values().stream().filter(x -> x != 0).count();
        return mask1 == mask2 && count == 0;
    }
}