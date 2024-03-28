package leetcode.normal.j1997;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/description/">1997. 访问完所有房间的第一天</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length, mod = (int) 1e9 + 7;
        int[] dp = new int[n];
        dp[0] = 2;
        for (int i = 1; i < n; i++) {
            int to = nextVisit[i];
            dp[i] = dp[i - 1] + 2;
            if (to != 0) {
                dp[i] = (dp[i] - dp[to - 1] + mod) % mod;
            }
            dp[i] = (dp[i] + dp[i - 1]) % mod;
        }
        return dp[n - 2];
    }
}