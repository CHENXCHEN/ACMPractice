package leetcode.normal.j741;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/cherry-pickup/">741. 摘樱桃</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int maxStep = n << 1;
        // k <= 2n - 2 => k < 2n - 1
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        // dp[x1][x2] 为从 (0,0) 开始走，第 k 步时，当 A 在第 x1 行， B 在第 x2 行时，能摘到的最大数量
        // 在起点时，能获得的个数
        dp[0][0] = grid[0][0];
        for (int k = 1; k < maxStep - 1; k++) {
            // x1 + y1 = k, y1 = k - x1
            // y1 < n => k - x1 < n => k - n < x1
            // x1 >= 0 && y1 < n
            // 在走 k 步之后，最大的行不应该超过 min(k, n-1)
            int maxRow = Math.min(k, n - 1);
            // 在走 k 步之后，最小的行不应该小于 max(k - n + 1, 0)
            int minRow = Math.max(k - n + 1, 0);
            // 我们假定 x1 是在 x2 下面走的，这样就可以固定路线不用重复计算了
            for (int x1 = maxRow, y1 = k - x1; x1 >= minRow; x1--, y1++) {
                for (int x2 = maxRow, y2 = k - x2; x2 >= x1; x2--, y2++) {
                    // 如果第k步两个都不能走，就跳过
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1][x2] = Integer.MIN_VALUE;
                        continue;
                    }
                    // 如果是往右边走
                    int res = dp[x1][x2];
                    // 如果 A 往右，B 往下
                    if (x2 > 0) {
                        res = Math.max(res, dp[x1][x2 - 1]);
                    }
                    // 如果 A 往下，B 往右
                    if (x1 > 0) {
                        res = Math.max(res, dp[x1 - 1][x2]);
                    }
                    // 如果都往下边走
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, dp[x1 - 1][x2 - 1]);
                    }
                    res += grid[x1][y1];
                    // 如果不在同一个地方
                    if (x1 != x2) res += grid[x2][y2];
                    dp[x1][x2] = res;
                }
            }
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }
}