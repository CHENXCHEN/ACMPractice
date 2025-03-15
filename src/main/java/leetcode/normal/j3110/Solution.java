package leetcode.normal.j3110;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/score-of-a-string/description/">3110. 字符串的分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }
        return ans;
    }
}