package leetcode.normal.j1190;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * 1190. 反转每对括号间的子串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = IntStream.range(0, s.length()).toArray();
        IntStream.range(0, s.length())
                .forEach(i -> {
                    if (s.charAt(i) == '(') {
                        stack.push(i);
                    } else if (s.charAt(i) == ')') {
                        Integer start = stack.pop();
                        Integer end = i;
                        while (start < end) {
                            int tmp = ans[end];
                            ans[end] = ans[start];
                            ans[start] = tmp;
                            ++start;
                            --end;
                        }
                    }
                });
        return Arrays.stream(ans).filter(i -> s.charAt(i) != '(' && s.charAt(i) != ')')
                .mapToObj(s::charAt)
                .map(Object::toString).collect(Collectors.joining());
    }
}
