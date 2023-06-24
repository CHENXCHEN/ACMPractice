package leetcode.normal.j1659;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximize-grid-happiness/">1659. 最大化网格幸福感</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    // 行内分数，行内内向人数量，行内外向人数量
    int[] innerScore, ivCount, evCount;
    // 相邻行分数，行内第 i 列的状态
    int[][] interScore, maskBit;
    // 空地、内向、外向 构成的 9 种相邻情况下的增量分数
    int[][] score = {
            {0, 0, 0},
            {0, -60, -10},
            {0, -10, 40}
    };
    // dp[i][j][k][x] 表示为当前是第 i 行，上一行状态为 j，剩余可放置 k 个内向人，可放置 x 个外向人的情况下，最大幸福度是多少
    int[][][][] dp;
    int totRowStat, rows, cols;

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        rows = m;
        cols = n;
        totRowStat = (int) Math.pow(3, cols);
        innerScore = new int[totRowStat];
        interScore = new int[totRowStat][totRowStat];
        maskBit = new int[totRowStat][cols];
        ivCount = new int[totRowStat];
        evCount = new int[totRowStat];
        dp = new int[rows][totRowStat][introvertsCount + 1][extrovertsCount + 1];
        // 需要总结出一些特性：
        //      1. 每个位置只有三种情况：
        //          k = 0 表示这个位置是空的
        //          k = 1 表示这个位置为内向人的
        //          k = 2 表示这个位置是外向人的
        //      2. 只有相邻的格子才会造成影响，比如行与行，列与列
        // 如果枚举整个格子，那么复杂度很高( C(6,25) * C(6,19) )
        // 可以考虑枚举每一行和前一行的情况( 3^5 * 3^5 )，算最大幸福度
        initScore();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return dfs(0, 0, introvertsCount, extrovertsCount);
    }

    // 初始化行内和行间的分数
    void initScore() {
        // 行内分数
        for (int mask = 0; mask < totRowStat; mask++) {
            int tmpMask = mask;
            for (int i = 0; i < cols; i++) {
                int x = tmpMask % 3;
                tmpMask /= 3;
                maskBit[mask][i] = x;
                if (x == 1) {
                    // 内向
                    ivCount[mask]++;
                    innerScore[mask] += 120;
                } else if (x == 2) {
                    // 外向
                    evCount[mask]++;
                    innerScore[mask] += 40;
                }
                if (i > 0) {
                    // 减去相邻的增量分数
                    innerScore[mask] += score[x][maskBit[mask][i - 1]];
                }
            }
        }

        // 计算行间分数
        for (int preMask = 0; preMask < totRowStat; preMask++) {
            for (int curMask = preMask; curMask < totRowStat; curMask++) {
                for (int i = 0; i < cols; i++) {
                    interScore[preMask][curMask] += score[maskBit[preMask][i]][maskBit[curMask][i]];
                }
                interScore[curMask][preMask] = interScore[preMask][curMask];
            }
        }
    }

    int dfs(int curRow, int preMask, int iv, int ev) {
        if (curRow == rows || (iv == 0 && ev == 0)) {
            return 0;
        }
        if (dp[curRow][preMask][iv][ev] != -1)
            return dp[curRow][preMask][iv][ev];
        int res = 0;
        for (int mask = 0; mask < totRowStat; mask++) {
            if (ivCount[mask] > iv || evCount[mask] > ev) continue;
            res = Math.max(res,
                    dfs(curRow + 1, mask, iv - ivCount[mask], ev - evCount[mask])
                            + innerScore[mask] + interScore[preMask][mask]);
        }
        dp[curRow][preMask][iv][ev] = res;
        return res;
    }
}