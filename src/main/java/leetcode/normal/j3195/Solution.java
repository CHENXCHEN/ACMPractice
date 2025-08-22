package leetcode.normal.j3195;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-minimum-area-to-cover-all-ones-i/description/">3195. 包含所有 1 的最小矩形面积 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }
}