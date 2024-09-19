package leetcode.normal.j2414;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/description/">2414. 最长的字母序连续子字符串的长度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 0, i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(j) - s.charAt(j - 1) == 1) j++;
            ans = Math.max(ans, j - i);
            i = j;
        }
        return ans;
    }
}