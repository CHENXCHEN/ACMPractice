package leetcode.normal.j3033;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/modify-the-matrix/description/">3033. 修改矩阵</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[] maxCol = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = maxCol[j];
            }
        }
        return matrix;
    }
}