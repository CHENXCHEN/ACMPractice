package leetcode.normal.j1410;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/html-entity-parser/description/">1410. HTML 实体解析器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String entityParser(String text) {
        Map<String, String> mp = new HashMap<>();
        mp.put("&quot;", "\"");
        mp.put("&apos;", "'");
        mp.put("&amp;", "&");
        mp.put("&gt;", ">");
        mp.put("&lt;", "<");
        mp.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != '&') {
                sb.append(text.charAt(i));
            } else {
                Pair<String, String> res = find(mp, text, i);
                if (res != null) {
                    sb.append(res.getValue());
                    i += res.getKey().length() - 1;
                } else {
                    sb.append(text.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    Pair<String, String> find(Map<String, String> mp, String text, int pos) {
        for (String s : mp.keySet()) {
            if (check(s, text, pos)) {
                return new Pair<>(s, mp.get(s));
            }
        }
        return null;
    }

    boolean check(String subString, String text, int pos) {
        int i = 0, j = pos;
        while (i < subString.length() && j < text.length() && subString.charAt(i) == text.charAt(j)) {
            i++;
            j++;
        }
        return i == subString.length();
    }
}