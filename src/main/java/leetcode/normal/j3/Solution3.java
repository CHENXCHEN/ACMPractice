package leetcode.normal.j3;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        boolean[] has = new boolean[256];
        int left = 0, right = 0, n = s.length(), cnt = 0;
        while (right < n) {
            if (!has[s.charAt(right)]) {
                has[s.charAt(right)] = true;
                ++cnt;
                ++right;
            } else {
                while (has[s.charAt(right)]) {
                    has[s.charAt(left)] = false;
                    --cnt;
                    ++left;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}