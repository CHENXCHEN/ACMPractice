package leetcode.normal.j240;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 240. 搜索二维矩阵 II
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int x = 0, y = cols - 1;
        while (x < rows && y >= 0) {
            int vv = matrix[x][y];
            if (vv == target) return true;
            else if (vv > target) y--;
            else x++;
        }
        return false;
    }
}