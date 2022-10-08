package leetcode.normal.j856;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/score-of-parentheses/">856. 括号的分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int scoreOfParentheses(String s) {
        int ans = 0, cnt = 0;
        boolean isRight = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                isRight = false;
            } else {
                cnt--;
                if (!isRight) ans += 1 << (cnt);
                isRight = true;
            }
        }
        return ans;
    }
}