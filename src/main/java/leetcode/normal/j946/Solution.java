package leetcode.normal.j946;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/validate-stack-sequences/">946. 验证栈序列</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int pushPos = 0, popPos = 0;
        while (pushPos < pushed.length) {
            deque.push(pushed[pushPos++]);
            while (!deque.isEmpty() && popPos < popped.length && deque.peek() == popped[popPos]) {
                deque.pop();
                popPos++;
            }
        }
        while (!deque.isEmpty() && popPos < popped.length && deque.peek() == popped[popPos]) {
            deque.pop();
            popPos++;
        }
        return deque.isEmpty();
    }
}