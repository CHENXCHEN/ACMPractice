package leetcode.normal.j1945;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/">1945. 字符串转化后的各位数字之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int getLucky(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += calc(s.charAt(i) - 'a' + 1);
        }
        while (--k > 0) {
            int tmp = 0;
            while (ans > 0) {
                tmp += ans % 10;
                ans /= 10;
            }
            ans = tmp;
        }
        return ans;
    }

    int calc(int v) {
        return v < 10 ? v : v % 10 + v / 10;
    }
}