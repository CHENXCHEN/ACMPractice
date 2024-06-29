package leetcode.normal.j2742;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/painting-the-walls/description/">2742. 给墙壁刷油漆</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] dp = new int[n << 1 | 1];
        // 目标：最小花费
        // 变量：付费还是免费 + 免费工作的次数
        // dp[x] -> 表示 1...i 为止，当时间为 x 的最小花费
        Arrays.fill(dp, Integer.MAX_VALUE >> 1);
        dp[n] = 0;
        for (int i = 0; i < n; i++) {
            // cur[x] -> 表示 1...i 到当前的 i 时，当时间为 x 的最小花费
            int[] cur = new int[n << 1 | 1];
            Arrays.fill(cur, Integer.MAX_VALUE >> 1);
            for (int j = 0; j <= (n << 1); j++) {
                // 付费，如果当前这堵墙要花钱，那么将得到 time[i] 次免费工作的机会
                // 计算一共这么多的工作机会，一共花费最小是多少
                int costTime = Math.min(j + time[i], n << 1);
                cur[costTime] = Math.min(cur[costTime], dp[j] + cost[i]);
                // 免费，将消耗1次工作机会
                if (j > 0) {
                    cur[j - 1] = Math.min(cur[j - 1], dp[j]);
                }
            }
            dp = cur;
        }
        int ans = dp[n];
        for (int i = n + 1; i <= (n << 1); i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}