package leetcode.normal.j1180;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-substrings-with-only-one-distinct-letter/description/">1180. 统计只含单一字母的子串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countLetters(String s) {
        int ans = 0, i = 0;
        while (i < s.length()) {
            int cnt = 0;
            char ch = s.charAt(i);
            while (i < s.length() && s.charAt(i) == ch) {
                i++;
                cnt++;
            }
            ans += cnt * (cnt + 1) / 2;
        }
        return ans;
    }
}