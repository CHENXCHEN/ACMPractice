package leetcode.normal.j32;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else right++;
            if (right == left) {
                ans = Math.max(ans, right << 1);
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') left++;
            else right++;
            if (left == right) {
                ans = Math.max(ans, right << 1);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return ans;
    }
}
