package leetcode.normal.j871;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-refueling-stops/">871. 最低加油次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        // dp[j] 表示为走到第 i 个加油站时，加油次数为 j 时持有的最大汽油数
        // dp[0] = dp[0] if (dp[0] >= stations[i][0])
        // dp[j] = max(dp[j-1]) + stations[i][0], dp[j]) if (dp[i-1][j-1] >= stations[i][0])
        int n = stations.length;
        int[] dp = new int[n + 1];
        dp[0] = startFuel;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                // 判断政企前面的站台加了 j 个油能不能到达这个站台
                if (dp[j - 1] >= stations[i - 1][0])
                    dp[j] = Math.max(dp[j], dp[j - 1] + stations[i - 1][1]);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
}