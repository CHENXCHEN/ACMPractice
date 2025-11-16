package leetcode.normal.j1513;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-substrings-with-only-1s/description/">1513. 仅含 1 的子串数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numSub(String s) {
        int MOD = (int) (1e9 + 7);
        long ans = 0;
        int i = 0, cnt = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') ++cnt;
            else {
                ans = (ans + (1L + cnt) * cnt / 2) % MOD;
                cnt = 0;
            }
            i++;
        }
        ans = (ans + (1L + cnt) * cnt / 2) % MOD;
        return (int) ans;
    }
}