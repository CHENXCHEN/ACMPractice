package leetcode.normal.j32;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}
