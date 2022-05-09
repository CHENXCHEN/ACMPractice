package leetcode.normal.j942;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/di-string-match/
 * 942. 增减字符串匹配
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] diStringMatch(String s) {
        int lPos = 0, rPos = s.length();
        int[] ans = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                ans[i] = lPos++;
            } else {
                ans[i] = rPos--;
            }
        }
        ans[s.length()] = lPos;
        return ans;
    }
}