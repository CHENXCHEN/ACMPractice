package leetcode.normal.j2544;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/alternating-digit-sum/">2544. 交替数字和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if ((i & 1) == 1) num *= -1;
            ans += num;
        }
        return ans;
    }
}