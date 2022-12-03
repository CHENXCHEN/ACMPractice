package leetcode.normal.j1796;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/second-largest-digit-in-a-string/">1796. 字符串中第二大的数字</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int secondHighest(String s) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            if (ch >= 0 && ch <= 9) {
                if (ans[0] == -1 || ch > ans[0]) {
                    ans[1] = ans[0];
                    ans[0] = ch;
                } else if (ch != ans[0] && ch > ans[1]) {
                    ans[1] = ch;
                }
            }
        }
        return ans[1];
    }
}