package leetcode.normal.j1614;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses/
 * 1614. 括号的最大嵌套深度
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxDepth(String s) {
        int cnt = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cnt++;
                if (cnt > ans) ans = cnt;
            } else if (ch == ')') {
                cnt--;
            }
        }
        return ans;
    }
}