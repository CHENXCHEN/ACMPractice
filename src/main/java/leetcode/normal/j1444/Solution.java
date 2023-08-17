package leetcode.normal.j1444;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-ways-of-cutting-a-pizza/">1444. 切披萨的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length(), mod = 1_000_000_007;
        int[][] appleSum = new int[rows + 1][cols + 1];
        int[][][] dp = new int[k + 1][rows + 1][cols + 1];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                appleSum[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + appleSum[i + 1][j] + appleSum[i][j + 1] - appleSum[i + 1][j + 1];
                if (appleSum[i][j] > 0) dp[1][i][j] = 1;
            }
        }

        for (int t = 2; t <= k; t++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    // 水平切
                    for (int xi = i + 1; xi < rows; xi++) {
                        // 切的这一刀，每个部分必须包含至少 1 个苹果
                        if (appleSum[i][j] > appleSum[xi][j])
                            dp[t][i][j] = (dp[t][i][j] + dp[t - 1][xi][j]) % mod;
                    }
                    // 垂直切
                    for (int xj = j + 1; xj < cols; xj++) {
                        // 切的这一刀，每个部分必须包含至少 1 个苹果
                        if (appleSum[i][j] > appleSum[i][xj])
                            dp[t][i][j] = (dp[t][i][j] + dp[t - 1][i][xj]) % mod;
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}