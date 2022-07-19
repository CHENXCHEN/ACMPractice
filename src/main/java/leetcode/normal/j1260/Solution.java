package leetcode.normal.j1260;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shift-2d-grid/">1260. 二维网格迁移</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int rows = grid.length, cols = grid[0].length;
        int mod = rows * cols;
        k %= mod;
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                int next = (i * cols + j - k + mod) % mod;
                int x = next / cols, y = next % cols;
                cur.add(grid[x][y]);
            }
            ans.add(cur);
        }
        return ans;
    }
}