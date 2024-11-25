package leetcode.normal.j22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/generate-parentheses/description/">22. 括号生成</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder(n << 1);
        ArrayList<String> ans = new ArrayList<>();
        solve(ans, sb, 0, n);
        return ans;
    }

    void solve(List<String> ans, StringBuilder sb, int needClosed, int needOpen) {
        if (needOpen == 0 && needClosed == 0) {
            ans.add(sb.toString());
        }
        if (needOpen > 0) {
            sb.append('(');
            solve(ans, sb, needClosed + 1, needOpen - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (needClosed > 0) {
            sb.append(')');
            solve(ans, sb, needClosed - 1, needOpen);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}