package leetcode.normal.j1140;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/stone-game-ii/">1140. 石子游戏 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] preSum;
    int n;
    Integer[][] mem;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        preSum = new int[n + 1];
        // 记忆化
        mem = new Integer[n + 1][n + 1];
        // 预处理前缀和
        for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + piles[i];
        return dfs(0, 1);
    }

    int dfs(int i, int m) {
        // 如果当前可以把剩余的都取完
        if ((m << 1) >= n - i) return preSum[n] - preSum[i];
        // 如果取不完的话，那么枚举取 [1, m*2] 的情况下，当前能获得的最大石子数是多少
        if (mem[i][m] == null) {
            int res = 0, end = m << 1, cur = preSum[n] - preSum[i];
            for (int x = 1; x <= end && i + x < n; x++) {
                // 如果当前取前 x 堆，那当前情况可以获得的石子数为 ${剩余的石子数} - ${下一个人能取的石子数}
                res = Math.max(res, cur - dfs(i + x, Math.max(x, m)));
            }
            mem[i][m] = res;
            return res;
        }
        return mem[i][m];
    }
}