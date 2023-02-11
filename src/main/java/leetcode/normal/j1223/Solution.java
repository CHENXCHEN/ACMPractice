package leetcode.normal.j1223;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/dice-roll-simulation/description/">1223. 掷骰子模拟</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int MOD = 1000000007;
        // dp[i][j][k] 表示第 i 次甩，数字为 j，且 j 的连续次数为 k 的总次数是多少
        int[][][] dp = new int[2][6][16];
        for (int i = 0; i < 6; i++) {
            dp[1][i][1] = 1;
        }
        // 一共要甩 n 次
        for (int i = 2; i <= n; i++) {
            int cur = i & 1, pre = cur ^ 1;
            for (int j = 0; j < 6; j++) {
                Arrays.fill(dp[cur][j], 0);
            }
            // 上一个甩的数字为 j
            for (int j = 0; j < 6; j++) {
                // 上次甩的数字为 j 且连续的次数为 k 的情况
                for (int k = 1; k <= rollMax[j]; k++) {
                    // 枚举当前甩的为 p
                    for (int p = 0; p < 6; p++) {
                        if (p != j)
                            dp[cur][p][1] = (dp[cur][p][1] + dp[pre][j][k]) % MOD;
                        else if (k + 1 <= rollMax[j])
                            dp[cur][p][k + 1] = (dp[cur][p][k + 1] + dp[pre][j][k]) % MOD;
                    }
                }
            }
        }
        int ans = 0, last = n & 1;
        for (int j = 0; j < 6; j++) {
            for (int k = 1; k <= rollMax[j]; k++) {
                ans = (ans + dp[last][j][k]) % MOD;
            }
        }
        return ans;
    }
}