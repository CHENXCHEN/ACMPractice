package leetcode.normal.j1624;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-substring-between-two-equal-characters/">1624. 两个相同字符之间的最长子字符串</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstPos = new int[26], lastPos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            if (firstPos[ch] == 0) firstPos[ch] = i + 1;
            lastPos[ch] = i + 1;
        }
        int ans = -1;
        for (int i = 0; i < 26; i++) {
            ans = Math.max(ans, lastPos[i] - firstPos[i] - 1);
        }
        return ans;
    }
}