package leetcode.normal.j2132;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/stamping-the-grid/description/">2132. 用邮票贴满网格图</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = getV(dp, i - 1, j) + getV(dp, i, j - 1) - getV(dp, i - 1, j - 1) + grid[i][j];
            }
        }
        int[][] diff = new int[rows + 1][cols + 1];
        for (int i = stampHeight - 1; i < rows; i++) {
            for (int j = stampWidth - 1; j < cols; j++) {
                if (grid[i][j] >= 1) continue;
                int size = getV(dp, i, j) - getV(dp, i - stampHeight, j) - getV(dp, i, j - stampWidth) + getV(dp, i - stampHeight, j - stampWidth);
                if (size == 0) {
                    int x = i - stampHeight + 1, y = j - stampWidth + 1;
                    diff[x][y]++;
                    diff[x][j + 1]--;
                    diff[i + 1][y]--;
                    diff[i + 1][j + 1]++;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                diff[i][j] = getV(diff, i - 1, j) + getV(diff, i, j - 1) - getV(diff, i - 1, j - 1) + diff[i][j];
                if (grid[i][j] == 0 && diff[i][j] == 0) return false;
            }
        }
        return true;
    }

    int getV(int[][] arr, int i, int j) {
        if (i < 0 || j < 0) return 0;
        return arr[i][j];
    }
}