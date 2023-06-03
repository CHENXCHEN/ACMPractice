package leetcode.normal.j1130;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/">1130. 叶值的最小代价生成树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        // dp[i][j] -> 表示 [i,j] 这个区间内的生成树的和的最小值
        // mVal[i][j] -> 表示 [i,j] 这个区间内叶子节点的最大值
        int[][] dp = new int[n][n], mVal = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE >> 2);

        // 枚举两个端点 [i,j], k 在 [i,j] 范围内，为分割两个子树的位置，求 dp[i][j] 的生成树的最小值
        for (int j = 0; j < n; j++) {
            mVal[j][j] = arr[j];
            dp[j][j] = 0;
            for (int i = j - 1; i >= 0; i--) {
                mVal[i][j] = Math.max(mVal[i + 1][j], arr[i]);
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mVal[i][k] * mVal[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}