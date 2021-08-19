package leetcode.normal.j20;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 20. 有效的括号
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> matChar = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (matChar.containsValue(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || matChar.get(ch) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
