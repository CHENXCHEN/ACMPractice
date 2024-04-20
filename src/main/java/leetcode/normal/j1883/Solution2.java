package leetcode.normal.j1883;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-skips-to-arrive-at-meeting-on-time/description/">1883. 准时抵达会议现场的最小跳过休息次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        // dp[i][j] -> 到达第 i 段路，跳过 j 次最小时间
        // 假定 dist 和 hoursBefore 都 * speed，那么就可以转换为不用小数的方式求解
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], Long.MAX_VALUE);
        dp[0][0] = 0L;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    // 如果这一段路选择不跳过，那么时间花费要向上取整
                    dp[i][j] = Math.min(dp[i][j], ((dp[i - 1][j] + dist[i - 1] - 1) / speed + 1) * speed);
                }
                if (j != 0) {
                    // 如果这一段路选择跳过，那么时间花费不取整
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist[i - 1]);
                }
            }
        }
        long res = (long) hoursBefore * speed;
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] <= res) {
                return i;
            }
        }
        return -1;
    }
}