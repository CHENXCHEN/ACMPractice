package leetcode.normal.j49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/group-anagrams/">49. 字母异位词分组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            String hash = toHash(str);
            mp.compute(hash, (k, v) -> v == null ? new ArrayList<>() : v).add(str);
        }
        return new ArrayList<>(mp.values());
    }

    String toHash(String str) {
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                sb.append(cnt[i]).append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}