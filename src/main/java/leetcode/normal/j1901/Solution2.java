package leetcode.normal.j1901;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-a-peak-element-ii/description/">1901. 寻找峰值 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int left = 0, right = rows - 1;
        while (left <= right) {
            int i = (left + right) >> 1, j = 0;
            for (int k = 1; k < cols; k++) {
                if (mat[i][j] < mat[i][k]) j = k;
            }
            if (i - 1 >= 0 && mat[i - 1][j] > mat[i][j]) {
                right = i - 1;
                continue;
            }
            if (i + 1 < rows && mat[i + 1][j] > mat[i][j]) {
                left = i + 1;
                continue;
            }
            return new int[]{i, j};
        }
        return new int[0];
    }
}
