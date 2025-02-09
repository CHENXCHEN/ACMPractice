package leetcode.normal.j249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/group-shifted-strings/description/">249. 移位字符串分组</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, Integer> vis = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String string : strings) {
            String s = aliaString(string);
            Integer idx = vis.getOrDefault(s, vis.size());
            if (idx == res.size()) res.add(new ArrayList<>());
            res.get(idx).add(string);
            vis.put(s, idx);
        }
        return res;
    }

    String aliaString(String str) {
        // 将字符串首字母对齐到 'a' 的偏差
        int diff = str.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = (char) ((str.charAt(i) - 'a' - diff + 26) % 26);
            sb.append(ch);
        }
        return sb.toString();
    }
}