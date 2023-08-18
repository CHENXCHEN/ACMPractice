package leetcode.normal.j1388;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/pizza-with-3n-slices/description/">1388. 3n 块披萨</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxSizeSlices(int[] slices) {
        int[] subSlices = new int[slices.length - 1];
        System.arraycopy(slices, 0, subSlices, 0, subSlices.length);
        int ans1 = calc(subSlices);
        System.arraycopy(slices, 1, subSlices, 0, subSlices.length);
        int ans2 = calc(subSlices);
        return Math.max(ans1, ans2);
    }

    int calc(int[] slices) {
        int len = slices.length, n = (len + 1) / 3;
        int[][] dp = new int[len][n + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        dp[0][1] = slices[0];
        dp[1][0] = 0;
        dp[1][1] = Math.max(slices[0], slices[1]);
        for (int i = 2; i < len; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                // 如果不选第 i 个元素，那么取 dp[i-1][j]
                // 如果选择第 i 个元素，那么取 dp[i-2][j-1]
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 2][j - 1] + slices[i]);
            }
        }
        return dp[len - 1][n];
    }
}