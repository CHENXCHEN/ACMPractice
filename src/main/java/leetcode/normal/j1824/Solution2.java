package leetcode.normal.j1824;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-sideway-jumps/">1824. 最少侧跳次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        for (int i = 0; i < n; i++) obstacles[i]--;
        int[] dp = new int[3];
        dp[0] = dp[2] = 1;
        dp[1] = 0;
        for (int i = 1; i < n; i++) {
            int minCut = Integer.MAX_VALUE, ob = obstacles[i];
            for (int j = 0; j < 3; j++) {
                if (j == ob) dp[j] = Integer.MAX_VALUE;
                else minCut = Math.min(minCut, dp[j]);
            }
            for (int j = 0; j < 3; j++) {
                if (j != ob) {
                    dp[j] = Math.min(dp[j], minCut + 1);
                }
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}