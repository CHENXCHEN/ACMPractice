package leetcode.normal.j2690;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/zero-matrix-lcci/">面试题 01.08. 零矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] rowMark = new int[rows], colMark = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    colMark[j] = rowMark[i] = 1;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowMark[i] == 1) matrix[i][j] = 0;
                else if (colMark[j] == 1) matrix[i][j] = 0;
            }
        }
    }
}