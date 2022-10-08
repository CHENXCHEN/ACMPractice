package leetcode.normal.j856;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/score-of-parentheses/">856. 括号的分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int scoreOfParentheses(String s) {
        int ans = 0, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == '(' ? 1 : -1;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') ans += 1 << cnt;
        }
        return ans;
    }
}