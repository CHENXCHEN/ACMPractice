package leetcode.normal.j71;

import java.util.Stack;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/simplify-path/
 * 71. 简化路径
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        stack.push("");
        int i = 0;
        while (i < path.length()) {
            int j = path.indexOf('/', i);
            if (j == -1) j = path.length();
            String sub = path.substring(i, j);
            if (j - i > 0)
                switch (sub) {
                    case ".":
                        break;
                    case "..":
                        if (stack.size() > 1) stack.pop();
                        break;
                    default:
                        stack.push(sub);
                }
            i = j + 1;
        }
        if (stack.size() == 1) return "/";
        return String.join("/", stack);
    }
}