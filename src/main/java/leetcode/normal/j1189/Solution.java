package leetcode.normal.j1189;

/**
 * Created by CHENXCHEN
 * 1189. “气球” 的最大数量
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] has = new int[26];
        for (int i = 0; i < text.length(); i++) {
            has[text.charAt(i) - 'a']++;
        }
        String s = "balloon";
        int[] hasStr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hasStr[s.charAt(i) - 'a']++;
        }
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            int need = has[ch] / hasStr[ch];
            if (ans == -1) {
                ans = need;
            } else {
                ans = Math.min(ans, need);
            }
        }
        return ans;
    }
}