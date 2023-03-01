package leetcode.normal.j2373;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-local-values-in-a-matrix/">2373. 矩阵中的局部最大值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int tmp = 0;
                for (int m = i - 1; m <= i + 1; m++) {
                    for (int k = j - 1; k <= j + 1; k++) {
                        tmp = Math.max(tmp, grid[m][k]);
                    }
                }
                ans[i - 1][j - 1] = tmp;
            }
        }
        return ans;
    }
}