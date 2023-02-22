package leetcode.normal.j1140;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/stone-game-ii/">1140. 石子游戏 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int stoneGameII(int[] piles) {
        int n = piles.length, ss = 0;
        int[][] dp = new int[n][n + 1];
        // 跟记忆化搜索的思路是一样的，dp[i][j] 表示还剩下 [i,n-1] 的石子堆时，j=M 的最大石子数
        for (int i = piles.length - 1; i >= 0; i--) {
            ss += piles[i];
            for (int M = 1; M <= n; M++) {
                int sizeM = M << 1;
                if (i + sizeM >= n) {
                    // 如果当前状态可以把剩下的石子都取完的话
                    dp[i][M] = ss;
                } else {
                    // 如果取不完，那么枚举 x -> [1,m*2]，当前的石子数为 ${还剩下的石子数} - ${下一个人能取的石子数}
                    for (int x = 1; x <= sizeM; x++) {
                        dp[i][M] = Math.max(dp[i][M], ss - dp[i + x][Math.max(x, M)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}