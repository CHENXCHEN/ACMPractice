package leetcode.normal.j808;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/soup-servings/description/">808. 分汤</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        // 当我们进行实际计算时发现，当 n >= 4475 时，所求概率已经大于 0.99999 了
        // 概率论，浮点数精度
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1.0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]) / 4.0;
            }
        }
        return dp[n][n];
    }
}