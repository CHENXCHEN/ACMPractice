package leetcode.normal.j1504;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-submatrices-with-all-ones/description/">1504. 统计全 1 子矩形</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        // row[i][j] 表示(i,j)的左边有多少个1
        int[][] row = new int[rows][cols];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    row[i][j] = mat[i][j];
                } else {
                    row[i][j] = mat[i][j] == 0 ? 0 : (row[i][j - 1] + 1);
                }
                // 计算以 (i,j) 为右下角的矩形数
                int cur = row[i][j];
                for (int k = i; k >= 0; k--) {
                    cur = Math.min(cur, row[k][j]);
                    if (cur == 0) break;
                    ans += cur;
                }
            }
        }
        return ans;
    }
}