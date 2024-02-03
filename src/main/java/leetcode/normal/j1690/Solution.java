package leetcode.normal.j1690;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/stone-game-vii/description/">1690. 石子游戏 VII</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] preSum;
    // dp[i][j] -> 表示在面对 [i,j] 这种场景时，得分的差值最大是多少?
    // dp[i][j] = Math.max(sum(i+1,j) - dp[i+1][j], sum(i,j+1) - dp[i][j-1])
    int[][] dp;

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        dp = new int[n][n];
        return dfs(0, n - 1);
    }

    int dfs(int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        dp[i][j] = Math.max(preSum[j + 1] - preSum[i + 1] - dfs(i + 1, j), preSum[j] - preSum[i] - dfs(i, j - 1));
        return dp[i][j];
    }
}