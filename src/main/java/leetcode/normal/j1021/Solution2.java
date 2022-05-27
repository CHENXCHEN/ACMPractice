package leetcode.normal.j1021;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 * 1021. 删除最外层的括号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public String removeOuterParentheses(String s) {
        int leftCnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                --leftCnt;
                if (leftCnt > 0) sb.append(')');
            } else {
                ++leftCnt;
                if (leftCnt > 1) sb.append('(');
            }
        }
        return sb.toString();
    }
}