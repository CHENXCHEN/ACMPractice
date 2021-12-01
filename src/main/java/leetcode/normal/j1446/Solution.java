package leetcode.normal.j1446;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/consecutive-characters/
 * 1446. 连续字符
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxPower(String s) {
        char ch = s.charAt(0);
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                cnt ++;
            } else {
                cnt = 1;
                ch = s.charAt(i);
            }
            if (cnt > ans) ans = cnt;
        }
        return ans;
    }
}