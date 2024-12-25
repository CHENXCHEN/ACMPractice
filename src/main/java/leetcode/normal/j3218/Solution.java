package leetcode.normal.j3218;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-for-cutting-cake-i/description/">3218. 切蛋糕的最小总开销 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] mem;
    int rows, cols;
    int[] hCut, vCut;

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        this.hCut = horizontalCut;
        this.vCut = verticalCut;
        this.rows = m;
        this.cols = n;
        int tot = (m + 1) * (n + 1);
        mem = new int[tot + 1][tot + 1];
        for (int i = 0; i < mem.length; i++) Arrays.fill(mem[i], -1);
        return dfs(0, 0, rows, cols);
    }

    int dfs(int x, int y, int h, int w) {
        int mark1 = x * cols + y, mark2 = h * cols + w;
        if (mem[mark1][mark2] != -1) return mem[mark1][mark2];
        if (h == 1 && w == 1) return 0;
        int ans = Integer.MAX_VALUE;
        // 枚举所有情况，获取最小开销
        // 枚举垂直切分的所有情况
        for (int i = 0; i < w - 1; i++) {
            ans = Math.min(ans, vCut[y + i] + dfs(x, y, h, i + 1) + dfs(x, y + i + 1, h, w - 1 - i));
        }
        // 枚举水平切分的所有情况
        for (int i = 0; i < h - 1; i++) {
            ans = Math.min(ans, hCut[x + i] + dfs(x, y, i + 1, w) + dfs(x + i + 1, y, h - 1 - i, w));
        }
        mem[mark1][mark2] = ans;
        return ans;
    }
}