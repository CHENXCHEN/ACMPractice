package leetcode.normal.j1758;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/">1758. 生成交替二进制字符串的最少操作数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minOperations(String s) {
        int cur1 = 0, cur2 = 1, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - '0';
            if (ch != cur1) ++cnt1;
            if (ch != cur2) ++cnt2;
            cur1 = 1 - cur1;
            cur2 = 1 - cur2;
        }
        return Math.min(cnt1, cnt2);
    }
}