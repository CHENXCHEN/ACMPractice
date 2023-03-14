package leetcode.normal.j1605;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/">1605. 给定行和列的和求可行矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int rowNum = rowSum.length, colNum = colSum.length;
        int[][] ans = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}