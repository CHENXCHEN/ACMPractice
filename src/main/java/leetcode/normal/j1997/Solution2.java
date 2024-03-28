package leetcode.normal.j1997;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/first-day-where-you-have-been-in-all-the-rooms/description/">1997. 访问完所有房间的第一天</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length, mod = (int) 1e9 + 7;
        long[] s = new long[n];
        // 使用前缀和来优化 dp
        // 假设 dp[i] 为到达第 i+1 间房所需要的天数，设 to = nextVisit[i]
        // 那么 dp[i] = dp[to] + ... + dp[i-1] + 2
        // 假设有前缀和 s[i+1] = s[i] + dp[i], s[0] = 0
        // 那么有 dp[i] = s[i] - s[to] + 2
        // 结合上面两个式子，可以得 s[i+1] = s[i] * 2 - s[j] + 2
        for (int i = 0; i < n - 1; i++) {
            int j = nextVisit[i];
            s[i + 1] = ((s[i] << 1) - s[j] + 2 + mod) % mod;
        }
        return (int) s[n - 1];
    }
}