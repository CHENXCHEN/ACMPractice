package leetcode.normal.j980;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/unique-paths-iii/solutions/2365866/bu-tong-lu-jing-iii-by-leetcode-solution-cndw/">不同路径 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;
    int rows, cols;
    int[][] dir = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        int startI = 0, startJ = 0, n = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) ++n;
                else if (grid[i][j] == 1) {
                    ++n;
                    startI = i;
                    startJ = j;
                }
            }
        }
        return dfs(startI, startJ, n);
    }

    int dfs(int x, int y, int left) {
        if (grid[x][y] == 2) {
            return left == 0 ? 1 : 0;
        }
        grid[x][y] = -1;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] != -1) {
                res += dfs(nx, ny, left - 1);
            }
        }
        grid[x][y] = 0;
        return res;
    }
}