package leetcode.normal.j3148;

import java.util.Arrays;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-difference-score-in-a-grid/description/">3148. 矩阵中的最大得分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int rows = grid.size(), cols = grid.get(0).size();
        int[][] preMax = new int[rows][cols], dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], preMax[i - 1][j] + grid.get(i).get(j));
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], preMax[i][j - 1] + grid.get(i).get(j));
                }
                preMax[i][j] = Math.max(dp[i][j], 0) - grid.get(i).get(j);
                if (i > 0) preMax[i][j] = Math.max(preMax[i][j], preMax[i - 1][j]);
                if (j > 0) preMax[i][j] = Math.max(preMax[i][j], preMax[i][j - 1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}