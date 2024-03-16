package leetcode.normal.j2684;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-number-of-moves-in-a-grid/description/">2684. 矩阵中移动的最大次数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
    int ans, rows, cols;
    int[][] grid;

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        ans = 0;
        for (int i = 0; i < rows; i++) dfs(i, 0);
        return ans;
    }

    void dfs(int i, int j) {
        ans = Math.max(ans, j);
        if (ans == cols - 1) {
            return;
        }
        for (int[] d : dir) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < rows && y >= 0 && y < cols && grid[i][j] < grid[x][y]) {
                dfs(x, y);
            }
        }
        // 从这个点出发的所有可能已经考虑过了，不需要再考虑
        grid[i][j] = 0;
    }
}