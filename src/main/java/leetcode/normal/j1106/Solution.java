package leetcode.normal.j1106;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/parsing-a-boolean-expression/">1106. 解析布尔表达式</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int valTrue = 1, valFalse = 0, valSep = 2;

    public boolean parseBoolExpr(String expression) {
        ArrayDeque<Character> opDeque = new ArrayDeque<>();
        ArrayDeque<Integer> vDeque = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isOp(ch)) {
                opDeque.push(ch);
            } else if (ch == 't' || ch == 'f') {
                int vv = ch == 't' ? valTrue : valFalse;
                if (!vDeque.isEmpty() && vDeque.peek() != valSep) {
                    vDeque.push(op(opDeque.peek(), vDeque.pop(), vv));
                } else vDeque.push(vv);
            } else if (ch == '(') {
                vDeque.push(valSep);
            } else if (ch == ')') {
                char opAction = opDeque.pop();
                int tmp = vDeque.peek();
                while (vDeque.peek() != valSep) {
                    tmp = op(opAction, tmp, vDeque.pop());
                }
                vDeque.pop();
                vDeque.push(tmp);
            }
        }
        return vDeque.pop() == valTrue;
    }

    int op(char ch, int va, int vb) {
        boolean a = va == valTrue;
        boolean b = vb == valTrue;
        switch (ch) {
            case '|':
                return (a | b) ? valTrue : valFalse;
            case '&':
                return (a & b) ? valTrue : valFalse;
            case '!':
                return !a ? valTrue : valFalse;
        }
        throw new RuntimeException("not support for op " + ch);
    }

    boolean isOp(char ch) {
        return ch == '|' || ch == '&' || ch == '!';
    }
}