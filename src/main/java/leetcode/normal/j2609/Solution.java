package leetcode.normal.j2609;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/description/">2609. 最长平衡子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int idx = 0, cnt0, cnt1, ans = 0;
        while (idx < s.length()) {
            cnt0 = cnt1 = 0;
            while (idx < s.length() && s.charAt(idx) == '0') {
                ++cnt0;
                ++idx;
            }
            while (idx < s.length() && s.charAt(idx) == '1') {
                ++cnt1;
                ++idx;
            }
            ans = Math.max(ans, Math.min(cnt0, cnt1) << 1);
        }
        return ans;
    }
}