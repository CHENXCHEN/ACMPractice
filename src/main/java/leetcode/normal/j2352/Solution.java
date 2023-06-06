package leetcode.normal.j2352;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/equal-row-and-column-pairs/">2352. 相等行列对</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[][] grid;
    int n;

    public int equalPairs(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (compare(i, j)) ans++;
            }
        }
        return ans;
    }

    boolean compare(int x, int y) {
        for (int i = 0; i < n; i++) {
            if (grid[x][i] != grid[i][y]) return false;
        }
        return true;
    }
}