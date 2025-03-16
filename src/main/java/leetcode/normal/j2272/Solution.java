package leetcode.normal.j2272;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/substring-with-largest-variance/description/">2272. 最大波动的子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestVariance(String s) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        // 枚举出现次数最多的和最少的字符数，c0 是出现次数最多的，c1 是出现次数最少的
        for (char c0 : map.keySet()) {
            for (char c1 : map.keySet()) {
                if (c0 == c1) continue;
                ArrayList<Integer> pos0 = map.get(c0), pos1 = map.get(c1);
                int i = 0, j = 0;
                // f 表示到当前位置的最大和，g 表示到当前位置包含 c1 的最大和
                int f = 0, g = Integer.MIN_VALUE;
                while (i < pos0.size() || j < pos1.size()) {
                    if (j == pos1.size() || (i < pos0.size() && pos0.get(i) < pos1.get(j))) {
                        f = Math.max(f, 0) + 1;
                        g = g + 1;
                        i++;
                    } else {
                        g = Math.max(Math.max(f, g), 0) - 1;
                        f = Math.max(f, 0) - 1;
                        j++;
                    }
                    ans = Math.max(ans, g);
                }
            }
        }
        return ans;
    }
}