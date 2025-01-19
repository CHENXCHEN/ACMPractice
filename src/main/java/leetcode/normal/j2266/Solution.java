package leetcode.normal.j2266;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-texts/description/">2266. 统计打字方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long mod = (int) 1e9 + 7;

    public int countTexts(String pressedKeys) {
        long ans = 1;
        char last = '0';
        int cnt = 1;
        int[] mp = {1, 1, 3, 3, 3, 3, 3, 4, 3, 4};
        for (char c : pressedKeys.toCharArray()) {
            if (c == last) {
                ++cnt;
            } else {
                ans = (calc(cnt, mp[last - '0']) * ans) % mod;
                cnt = 1;
                last = c;
            }
        }
        ans = (ans * calc(cnt, mp[last - '0'])) % mod;
        return (int) ans;
    }

    long calc(int len, int maxLimit) {
        long[] dp = new long[len + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= maxLimit && i - j >= 0; j++) {
                dp[i] = (dp[i] + dp[i - j]) % mod;
            }
        }
        return dp[len];
    }
}