package leetcode.normal.j1582;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/special-positions-in-a-binary-matrix/">1582. 二进制矩阵中的特殊位置</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numSpecial(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] rowCnt = new int[rows], colCnt = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && rowCnt[i] == 1 && colCnt[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}