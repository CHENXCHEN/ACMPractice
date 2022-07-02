package leetcode.normal.j871;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-refueling-stops/">871. 最低加油次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        // dp[i][j] 表示为走到第 i 个加油站时，加油次数为 j 时持有的最大汽油数
        // dp[i][0] = dp[i-1][0] if (dp[i-1][0] >= stations[i][0])
        // dp[i][j] = max(dp[i-1][j-1]) + stations[i][0], dp[i-1][j]) if (dp[i-1][j-1] >= stations[i][0])
        int n = stations.length;
        int[][] dp = new int[n + 2][n + 2];
        dp[0][0] = startFuel;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = -1;
                // 判断在前面的站台加了 j 次油能不能到达此处站台
                if (dp[i - 1][j] >= stations[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 判断政企前面的站台加了 j-1 次油能不能到达这个站台
                if (j > 0 && dp[i - 1][j - 1] >= stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + stations[i - 1][1], dp[i][j]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] >= target) {
                return i;
            }
        }
        return -1;
    }
}