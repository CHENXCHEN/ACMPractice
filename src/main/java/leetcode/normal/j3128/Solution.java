package leetcode.normal.j3128;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/right-triangles/description/">3128. 直角三角形</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] cntCol = new int[cols], cntRow = new int[rows];
        long ans = 0L;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cntRow[i] += grid[i][j];
                cntCol[j] += grid[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int r = cntRow[i], c = cntCol[j];
                if (grid[i][j] == 1 && r >= 2 && c >= 2) {
                    ans += (long) (r - 1) * (c - 1);
                }
            }
        }
        return ans;
    }
}