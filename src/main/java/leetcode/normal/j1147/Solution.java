package leetcode.normal.j1147;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-chunked-palindrome-decomposition/">1147. 段式回文</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        int l = 0, r = n - 1;
        int ans = 0;
        while (l <= r) {
            int len = 1;
            while (l + len - 1 < r - len + 1) {
                // 可以证明，每次取最小长度的前后缀，可以得到最大数，先找到最小的相等前后缀，找到后分组数+2
                if (isPrefixSuffix(text, l, r - len + 1, len)) {
                    ans += 2;
                    break;
                }
                ++len;
            }
            // 如果找不到，那么中间自成一组
            if (l + len - 1 >= r - len + 1) ++ans;
            l += len;
            r -= len;
        }
        return ans;
    }

    boolean isPrefixSuffix(String text, int l, int r, int len) {
        while (len > 0) {
            if (text.charAt(l) != text.charAt(r)) return false;
            l++;
            r++;
            len--;
        }
        return true;
    }
}