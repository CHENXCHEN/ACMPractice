package leetcode.normal.j1221;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * 1221. 分割平衡字符串
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int balancedStringSplit(String s) {
        int ans = 0, cntL = 0, cntR = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                cntL++;
            } else {
                cntR++;
            }
            if (cntL == cntR) ans++;
        }
        return ans;
    }
}