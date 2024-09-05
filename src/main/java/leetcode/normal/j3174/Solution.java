package leetcode.normal.j3174;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/clear-digits/description/">3174. 清除数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String clearDigits(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                if (!deque.isEmpty()) deque.pop();
            } else deque.push(s.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!deque.isEmpty()) sb.append(deque.pop());
        return sb.reverse().toString();
    }
}