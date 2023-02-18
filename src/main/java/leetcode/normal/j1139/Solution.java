package leetcode.normal.j1139;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-1-bordered-square/">1139. 最大的以 1 为边界的正方形</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] rowSum, colSum;
    int rows, cols;

    public int largest1BorderedSquare(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        // 计算行的前缀和以及列的前缀和
        rowSum = new int[rows + 1][cols + 1];
        colSum = new int[rows + 1][cols + 1];
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[i + 1][j] = colSum[i][j] + grid[i][j];
            }
        }
        for (int i = 0; i + ans < rows; i++) {
            for (int j = 0; j + ans < cols; j++) {
                // 枚举 (i,j) 开始，长度为 k + 1 是否可以组成正方形
                for (int k = ans; k + i < rows && k + j < cols; k++) {
                    if (checkIfSquare(i, j, k + 1)) ans = k + 1;
                }
            }
        }
        return ans * ans;
    }

    boolean checkIfSquare(int x, int y, int len) {
        return rowSum[x][y + len] - rowSum[x][y] == len &&
                rowSum[x + len - 1][y + len] - rowSum[x + len - 1][y] == len &&
                colSum[x + len][y] - colSum[x][y] == len &&
                colSum[x + len][y + len - 1] - colSum[x][y + len - 1] == len
                ;
    }
}