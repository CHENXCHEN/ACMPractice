package leetcode.normal.j3242;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/design-neighbor-sum-service/description/">3242. 设计相邻元素求和服务</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class NeighborSum {
    int rows, cols;
    int[] mp;
    int[][] grid;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        mp = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cur = i * cols + j;
                mp[grid[i][j]] = cur;
            }
        }
    }

    public int adjacentSum(int value) {
        int cur = mp[value];
        int row = cur / rows, col = cur % rows;
        int ans = 0;
        if (row - 1 >= 0) ans += grid[row - 1][col];
        if (col - 1 >= 0) ans += grid[row][col - 1];
        if (row + 1 < rows) ans += grid[row + 1][col];
        if (col + 1 < cols) ans += grid[row][col + 1];
        return ans;
    }

    public int diagonalSum(int value) {
        int cur = mp[value];
        int row = cur / rows, col = cur % rows;
        int ans = 0;
        if (row - 1 >= 0 && col - 1 >= 0) ans += grid[row - 1][col - 1];
        if (row - 1 >= 0 && col + 1 < cols) ans += grid[row - 1][col + 1];
        if (row + 1 < rows && col + 1 < cols) ans += grid[row + 1][col + 1];
        if (row + 1 < rows && col - 1 >= 0) ans += grid[row + 1][col - 1];
        return ans;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */