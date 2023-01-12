package leetcode.normal.j1807;

import java.util.HashMap;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/">1807. 替换字符串中的括号内容</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mm = new HashMap<>();
        for (List<String> item : knowledge) {
            mm.put(item.get(0), item.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != '(') sb.append(s.charAt(i++));
            int j = i;
            while (j < s.length() && s.charAt(j) != ')') j++;
            if (i != j) {
                String vv = mm.getOrDefault(s.substring(i + 1, j), "?");
                sb.append(vv == null ? "?" : vv);
            }
            i = j + 1;
        }
        return sb.toString();
    }
}