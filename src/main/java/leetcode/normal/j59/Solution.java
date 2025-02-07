package leetcode.normal.j59;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">59. 螺旋矩阵 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int x = 0, y = 0, tot = 0;
        while (true) {
            int step = 0;
            // 顺序为：右，下，左，上，直到无路可走
            // 先往右边走
            while (y < n && matrix[x][y] == 0) {
                ++step;
                matrix[x][y] = ++tot;
                ++y;
            }
            // 下一个位置是左下角
            --y;
            ++x;
            // 再往下边走
            while (x < n && matrix[x][y] == 0) {
                ++step;
                matrix[x][y] = ++tot;
                ++x;
            }
            // 下一个位置是左上角
            --x;
            --y;
            // 再往左边走
            while (y >= 0 && matrix[x][y] == 0) {
                ++step;
                matrix[x][y] = ++tot;
                --y;
            }
            // 下一个位置是右上角
            ++y;
            --x;
            // 再往上边走
            while (x >= 0 && matrix[x][y] == 0) {
                ++step;
                matrix[x][y] = ++tot;
                --x;
            }
            // 下一个位置是右下角
            ++x;
            ++y;
            if (step == 0) break;
        }
        return matrix;
    }
}