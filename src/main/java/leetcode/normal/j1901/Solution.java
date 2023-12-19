package leetcode.normal.j1901;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-a-peak-element-ii/description/">1901. 寻找峰值 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int maxAns = Integer.MIN_VALUE, x = 0, y = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] > maxAns) {
                    maxAns = mat[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x, y};
    }
}