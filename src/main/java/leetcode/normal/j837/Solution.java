package leetcode.normal.j837;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/new-21-game/description/">837. 新 21 点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // 每次抽取 [1, maxPts]，抽到 >= k 为止，求不超过 n 的概率
        // 1. 当分数 >= k，游戏结束，当游戏结束时，分数 <= n 则获胜，否则失败
        // 我们需要倒推概率
        // dp[i] 表示从得分为 i 的情况开始游戏并且获胜的概率，目标是求 dp[0]
        // dp[i] = sum(dp[i+1, ..., i + maxPts]) * rate
        // preSum[i] = sum(dp[i+1, ..., n])
        double[] dp = new double[n + 1], preSum = new double[n + 2];
        // 当 i 在 [k,min(n, k + maxPts-1)] 之间时，结果是 1，因为不可能走到 k + maxPts
        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1;
        }
        for (int i = n; i >= k && i - 1 >= 0; i--) {
            preSum[i - 1] = preSum[i] + dp[i];
        }
        double rate = 1.0 / maxPts;
        for (int i = k - 1; i >= 0; i--) {
            int left = i, right = Math.min(i + maxPts, n);
            dp[i] = (preSum[left] - preSum[right]) * rate;
            if (i != 0) {
                preSum[i - 1] = preSum[i] + dp[i];
            }
        }
        return dp[0];
    }
}