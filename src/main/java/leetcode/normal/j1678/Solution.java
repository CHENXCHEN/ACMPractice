package leetcode.normal.j1678;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/goal-parser-interpretation/">1678. 设计 Goal 解析器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == 'G') {
                sb.append(ch);
            } else if (ch == '(' && command.charAt(i + 1) == ')') {
                sb.append('o');
                i++;
            } else {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}