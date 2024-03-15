package leetcode.normal.j2312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/selling-pieces-of-wood/description/">2312. 卖木头块</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Map<Long, Integer> value;
    long[][] mem;
    int rows, cols;

    public long sellingWood(int m, int n, int[][] prices) {
        value = new HashMap<>();
        rows = m;
        cols = n;
        mem = new long[rows + 1][cols + 1];
        for (int i = 0; i <= rows; i++) Arrays.fill(mem[i], -1);
        for (int[] price : prices) {
            value.put(hashPos(price[0], price[1]), price[2]);
        }
        return solve(m, n);
    }

    long solve(int h, int w) {
        if (mem[h][w] != -1) return mem[h][w];
        long ret = value.getOrDefault(hashPos(h, w), 0);
        if (h > 1) {
            for (int i = 1; i < h; i++) {
                ret = Math.max(ret, solve(i, w) + solve(h - i, w));
            }
        }
        if (w > 1) {
            for (int i = 1; i < w; i++) {
                ret = Math.max(ret, solve(h, i) + solve(h, w - i));
            }
        }
        mem[h][w] = ret;
        return ret;
    }

    long hashPos(int x, int y) {
        return ((long) x << 16) | y;
    }
}