package leetcode.normal.j2306;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/naming-a-company/description/">2306. 公司命名</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> names = new HashMap<>();
        for (String idea : ideas) {
            names.compute(idea.charAt(0), (k, v) -> {
                v = v == null ? new HashSet<>() : v;
                v.add(idea.substring(1));
                return v;
            });
        }
        long ans = 0;
        for (Map.Entry<Character, Set<String>> entryA : names.entrySet()) {
            char chA = entryA.getKey();
            Set<String> setA = entryA.getValue();
            for (Map.Entry<Character, Set<String>> entryB : names.entrySet()) {
                char chB = entryB.getKey();
                Set<String> setB = entryB.getValue();
                if (chA == chB) continue;
                int intersect = calcIntersect(setA, setB);
                ans += (long) (setA.size() - intersect) * (setB.size() - intersect);
            }
        }
        return ans;
    }

    int calcIntersect(Set<String> setA, Set<String> setB) {
        int ans = 0;
        for (String s : setA) {
            if (setB.contains(s)) ans++;
        }
        return ans;
    }
}