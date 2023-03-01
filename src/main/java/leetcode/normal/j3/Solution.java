package leetcode.normal.j3;

import java.util.HashMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">3. 无重复字符的最长子串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, last = 0;
        HashMap<Character, Integer> mm = new HashMap<>();
        // 贪心，我们只需要离得最近的到目前位置没有重复字符的下标 last，[last,i] 之间没有重复字符，且 last 最小
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer chPos = mm.get(ch);
            if (chPos != null && chPos >= last) {
                last = chPos + 1;
            }
            mm.put(ch, i);
            ans = Math.max(ans, i - last + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("tmmzuxt");
    }
}