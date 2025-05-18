package leetcode.normal.j1931;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/painting-a-grid-with-three-different-colors/description/">1931. 用三种不同颜色为网格涂色</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Map<Integer, int[]> maskMap;
    int maskEnd, cols, rows;
    long MOD = (long) 1e9 + 7;

    public int colorTheGrid(int m, int n) {
        cols = m;
        rows = n;
        // 状态压缩成 3 进制，3^5 枚举
        maskEnd = (int) Math.pow(3, cols);
        long[][] dp = new long[2][maskEnd];
        // 计算合法的组合
        maskMap = getMaskMap();
        int cur = 0;
        for (int i = 0; i < maskEnd; i++) {
            if (maskMap.containsKey(i)) {
                dp[cur][i] = 1;
            }
        }
        // 计算相邻两行的合法转换组合
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (Map.Entry<Integer, int[]> nextEntry : maskMap.entrySet()) {
            for (Map.Entry<Integer, int[]> curEntry : maskMap.entrySet()) {
                if (validColors(curEntry.getValue(), nextEntry.getValue())) {
                    adj.computeIfAbsent(curEntry.getKey(), k -> new ArrayList<>()).add(nextEntry.getKey());
                }
            }
        }
        // 当前行的当前状态合法数 = 上一行的与当前状态的可以相邻的数
        for (int i = 1; i < rows; i++) {
            int next = cur ^ 1;
            for (Map.Entry<Integer, int[]> nextEntry : maskMap.entrySet()) {
                int nextMask = nextEntry.getKey();
                dp[next][nextMask] = 0;
                for (Integer curMask : adj.get(nextEntry.getKey())) {
                    dp[next][nextMask] = (dp[next][nextMask] + dp[cur][curMask]) % MOD;
                }
            }
            cur = next;
        }
        long ans = 0;
        for (Integer mask : maskMap.keySet()) {
            ans = (ans + dp[cur][mask]) % MOD;
        }
        return (int) ans;
    }

    boolean validColors(int[] color1, int[] color2) {
        for (int col = 0; col < cols; col++) {
            if (color1[col] == color2[col]) return false;
        }
        return true;
    }

    Map<Integer, int[]> getMaskMap() {
        Map<Integer, int[]> map = new HashMap<>();
        for (int mask = 0; mask < maskEnd; mask++) {
            int[] colors = new int[cols];
            boolean check = true;
            for (int j = 0, cur = mask; j < cols; j++, cur /= 3) {
                colors[j] = cur % 3;
                if (j > 0 && colors[j] == colors[j - 1]) {
                    check = false;
                    break;
                }
            }
            if (check) {
                map.put(mask, colors);
            }
        }
        return map;
    }
}