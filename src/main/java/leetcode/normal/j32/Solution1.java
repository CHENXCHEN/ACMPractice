package leetcode.normal.j32;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 32. 最长有效括号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution1 {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    ans = Math.max(ans, i - deque.peek());
                }
            }
        }
        return ans;
    }
}
