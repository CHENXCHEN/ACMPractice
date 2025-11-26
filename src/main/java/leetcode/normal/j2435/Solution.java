package leetcode.normal.j2435;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k/solutions/3835592/ju-zhen-zhong-he-neng-bei-k-zheng-chu-de-67ra/">2435. 矩阵中和能被 K 整除的路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        // dp[i][j][r] 表示，从左上角到 (i,j) 位置，其和 % k 的余数 = r 的方案数
        int[][][] dp = new int[rows][cols][k + 1];
        // r = (prev + grid[i][j]) % k
        // dp[i][j][r] += dp[i-1][j][prev]  + dp[i][j-1][prev];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j][grid[i][j] % k] = 1;
                    continue;
                }
                int cur = grid[i][j] % k;
                for (int r = 0; r < k; r++) {
                    int prev = (r - cur + k) % k;
                    int leftVal = i - 1 >= 0 ? dp[i - 1][j][prev] : 0;
                    int upVal = j - 1 >= 0 ? dp[i][j - 1][prev] : 0;
                    dp[i][j][r] = (leftVal + upVal) % MOD;
                }
            }
        }
        return dp[rows - 1][cols - 1][0];
    }
}