package leetcode.normal.j200;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-islands/description/">200. 岛屿数量</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        parent = new int[rows * cols];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        int[] cnt = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = i * cols + j;
                if (grid[i][j] == '1') {
                    if (j + 1 < cols && grid[i][j + 1] == '1') {
                        int y = i * cols + j + 1;
                        union(x, y);
                    }
                    if (i + 1 < rows && grid[i + 1][j] == '1') {
                        int y = (i + 1) * cols + j;
                        union(x, y);
                    }
                }
            }
        }
        int ans = 0;
        for (int x = 0; x < parent.length; x++) {
            int i = x / cols, j = x % cols;
            if (grid[i][j] == '1' && parent[x] == x) {
                ++ans;
            }
        }
        return ans;
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    void union(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx > fy) parent[fx] = fy;
        else parent[fy] = fx;
    }
}