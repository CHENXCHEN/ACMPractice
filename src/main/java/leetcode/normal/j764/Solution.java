package leetcode.normal.j764;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-plus-sign/">764. 最大加号标志</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid, rowSum, colSum;
    int n;

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        this.n = n;
        grid = new int[n][n];
        rowSum = new int[n][n];
        colSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], 1);
        }
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            rowSum[i][0] = grid[i][0];
            colSum[0][i] = grid[0][i];
            for (int j = 1; j < n; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i][j];
                colSum[j][i] = colSum[j - 1][i] + grid[j][i];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int maxK = getMaxK(i, j);
                if (maxK > ans) ans = maxK;
            }
        }
        return ans;
    }

    int getMaxK(int x, int y) {
        if (grid[x][y] == 0) return 0;
        int l = 0, r = n, ans = 0;
        while (l <= r) {
            int mid = (l + r) >> 1;
            boolean isLeft = y - mid + 1 >= 0 && y - mid + 1 < n && getRowLen(x, y - mid + 1, y) == mid;
            boolean isRight = y + mid - 1 < n && y + mid - 1 >= 0 && getRowLen(x, y, y + mid - 1) == mid;
            boolean isUp = x - mid + 1 >= 0 && x - mid + 1 < n && getColLen(y, x - mid + 1, x) == mid;
            boolean isDown = x + mid - 1 < n && x + mid - 1 >= 0 && getColLen(y, x, x + mid - 1) == mid;
            boolean isValid = isLeft & isRight & isUp & isDown;
            if (isValid) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }

    int getRowLen(int x, int y1, int y2) {
        if (y1 == 0) return rowSum[x][y2];
        return rowSum[x][y2] - rowSum[x][y1 - 1];
    }

    int getColLen(int y, int x1, int x2) {
        if (x1 == 0) return colSum[x2][y];
        return colSum[x2][y] - colSum[x1 - 1][y];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mines = {{4, 2}};
        solution.orderOfLargestPlusSign(5, mines);
    }
}