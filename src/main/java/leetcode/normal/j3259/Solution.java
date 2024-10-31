package leetcode.normal.j3259;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/description/">3259. 超级饮料的最大强化能量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[][] dp = new long[n][2];
        dp[0][0] = energyDrinkA[0];
        dp[0][1] = energyDrinkB[0];
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i][0] = dp[i - 1][0] + energyDrinkA[i];
                dp[i][1] = dp[i - 1][1] + energyDrinkB[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1]) + energyDrinkA[i];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0]) + energyDrinkB[i];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}