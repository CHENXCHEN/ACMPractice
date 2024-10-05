package leetcode.normal.j276;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/paint-fence/description/">276. 栅栏涂色</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numWays(int n, int k) {
        // dp[i][j][x] => 表示第 n 个栅栏是第 k 种颜色的方案数，第 j 个颜色出现了 x+1 次
        // dp[i][j][0] = dp[i-1][!j][0] + dp[i-1][!j][1]
        // dp[i][j][1] = dp[i-1][j][0]
        // 当前的组合数 = 第 i - 1 不以 j 为末尾的 + 第 i - 1 以 j 为末尾，连续出现 1 次的
        int[][][] dp = new int[n][k][2];
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            int curSum = 0;
            for (int j = 0; j < k; j++) {
                dp[i][j][0] = i > 0 ? (preSum - dp[i - 1][j][0] - dp[i - 1][j][1]) : 1;
                dp[i][j][1] = i > 0 ? dp[i - 1][j][0] : 0;
                curSum += dp[i][j][0] + dp[i][j][1];
            }
            preSum = curSum;
        }
        int ans = 0;
        for (int j = 0; j < k; j++) {
            ans += dp[n - 1][j][0] + dp[n - 1][j][1];
        }
        return ans;
    }
}