package leetcode.normal.j1021;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/remove-outermost-parentheses/
 * 1021. 删除最外层的括号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String removeOuterParentheses(String s) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                Integer pos = deque.removeLast();
                if (deque.isEmpty()) {
                    sb.append(s, pos + 1, i);
                }
            } else deque.addLast(i);
        }
        return sb.toString();
    }
}