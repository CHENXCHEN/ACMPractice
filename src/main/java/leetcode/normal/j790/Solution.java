package leetcode.normal.j790;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/domino-and-tromino-tiling/">790. 多米诺和托米诺平铺</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numTilings(int n) {
        long[][] dp = new long[2][4];
        long mod = 1000000000 + 7;
        int cur = 0;
        dp[cur][0] = 1;
        dp[cur][3] = 1;
        for (int i = 1; i < n; i++) {
            int pre = cur, next = (cur ^= 1);
            dp[next][0] = dp[pre][3] % mod;
            dp[next][1] = (dp[pre][0] + dp[pre][2]) % mod;
            dp[next][2] = (dp[pre][0] + dp[pre][1]) % mod;
            dp[next][3] = (dp[pre][3] + dp[pre][1] + dp[pre][2] + dp[pre][0]) % mod;
        }
        return (int) dp[cur][3];
    }
}