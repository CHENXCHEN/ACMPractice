package leetcode.normal.j1096;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/brace-expansion-ii/description/">1096. 花括号展开 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int idx = 0, n;
    String str;

    public List<String> braceExpansionII(String expression) {
        idx = 0;
        n = expression.length();
        str = expression;
        return new ArrayList<>(expr());
    }

    // item -> letter | { expr }
    Set<String> item() {
        Set<String> res = new TreeSet<>();
        if (str.charAt(idx) == '{') {
            ++idx;
            res = expr();
            ++idx;
        } else {
            StringBuilder sb = new StringBuilder();
            while (idx < n && Character.isLetter(str.charAt(idx))) {
                sb.append(str.charAt(idx));
                ++idx;
            }
            res.add(sb.toString());
        }
        return res;
    }

    // term -> item | item term
    Set<String> term() {
        Set<String> res = new TreeSet<String>() {{
            add("");
        }};
        while (idx < n && (str.charAt(idx) == '{' || Character.isLetter(str.charAt(idx)))) {
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<>();
            for (String left : res) {
                for (String right : sub) {
                    tmp.add(left + right);
                }
            }
            res = tmp;
        }
        return res;
    }

    // expr -> term | term, expr
    Set<String> expr() {
        Set<String> ts = new TreeSet<>();
        while (true) {
            ts.addAll(term());
            if (idx >= n || str.charAt(idx) != ',') break;
            ++idx;
        }
        return ts;
    }
}