package leetcode.normal.j2982;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-longest-special-substring-that-occurs-thrice-ii/description/">2982. 找出出现至少三次的最长特殊子字符串 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maximumLength(String s) {
        TreeMap<Integer, Integer>[] mp = new TreeMap[26];
        for (int i = 0; i < 26; i++) mp[i] = new TreeMap<>();
        int pos = 0, n = s.length();
        while (pos < n) {
            char ch = s.charAt(pos);
            int cnt = 0;
            while (pos < n && s.charAt(pos) == ch) {
                ++cnt;
                ++pos;
            }
            int idx = ch - 'a';
            mp[idx].compute(cnt, (k, v) -> (v == null ? 0 : v) + 1);
        }
        int ans = -1;
        for (int i = 0; i < 26; i++) {
            if (!mp[i].isEmpty()) {
                ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(mp[i].entrySet());
                boolean hasPre = false;
                for (int j = entries.size() - 1; j >= 0; j--) {
                    Map.Entry<Integer, Integer> entry = entries.get(j);
                    if (hasPre || entry.getValue() >= 3) {
                        ans = Math.max(ans, entry.getKey());
                    } else {
                        if (entry.getValue() == 2 && entry.getKey() > 1) ans = Math.max(ans, entry.getKey() - 1);
                        else if (entry.getValue() == 1 && entry.getKey() > 2) ans = Math.max(ans, entry.getKey() - 2);
                        hasPre = true;
                    }
                }
            }
        }
        return ans;
    }
}