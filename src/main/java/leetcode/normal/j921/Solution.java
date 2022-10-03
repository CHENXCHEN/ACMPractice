package leetcode.normal.j921;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/">921. 使括号有效的最少添加</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt < 0) {
                ans++;
                cnt = 0;
            }
        }
        return ans + cnt;
    }
}