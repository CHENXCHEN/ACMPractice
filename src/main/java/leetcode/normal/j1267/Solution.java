package leetcode.normal.j1267;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-servers-that-communicate/">1267. 统计参与通信的服务器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] markRow = new int[rows], markCol = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ++markRow[i];
                    ++markCol[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && (markRow[i] > 1 || markCol[j] > 1)) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}