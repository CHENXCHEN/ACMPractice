package leetcode.normal.j811;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/subdomain-visit-count/">811. 子域名访问计数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        TreeMap<String, Integer> tMap = new TreeMap<>();
        for (String domain : cpdomains) {
            String[] split = domain.split(" ");
            Integer cnt = Integer.valueOf(split[0]);
            int firstPos = split[1].indexOf('.'), lastPos = split[1].lastIndexOf('.');
            String s0 = split[1];
            tMap.put(s0, tMap.getOrDefault(s0, 0) + cnt);

            String s1 = split[1].substring(firstPos + 1);
            tMap.put(s1, tMap.getOrDefault(s1, 0) + cnt);

            if (firstPos != lastPos) {
                String s2 = split[1].substring(lastPos + 1);
                tMap.put(s2, tMap.getOrDefault(s2, 0) + cnt);
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> str : tMap.entrySet()) {
            ans.add(String.format("%d %s", str.getValue(), str.getKey()));
        }
        return ans;
    }
}