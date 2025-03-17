package leetcode.normal.j1963;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/">1963. 使字符串平衡的最小交换次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minSwaps(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return (stack.size() / 2 + 1) / 2;
    }
}