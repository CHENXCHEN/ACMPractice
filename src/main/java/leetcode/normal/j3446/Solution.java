package leetcode.normal.j3446;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/sort-matrix-by-diagonals/description/">3446. 按对角线进行矩阵排序</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int rows, cols;

    public int[][] sortMatrix(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int j = 1; j < cols; j++) {
            int x = 0, y = j;
            ArrayList<Integer> res = new ArrayList<>();
            while (isValid(x, y)) {
                res.add(grid[x][y]);
                x += 1;
                y += 1;
            }
            res.sort(Integer::compare);
            int k = 0;
            x = 0;
            y = j;
            while (isValid(x, y)) {
                grid[x][y] = res.get(k++);
                x += 1;
                y += 1;
            }
        }
        for (int i = 0; i < rows; i++) {
            int x = i, y = 0;
            ArrayList<Integer> res = new ArrayList<>();
            while (isValid(x, y)) {
                res.add(grid[x][y]);
                x += 1;
                y += 1;
            }
            res.sort((a, b) -> b - a);
            x = i;
            y = 0;
            int k = 0;
            while (isValid(x, y)) {
                grid[x][y] = res.get(k++);
                x += 1;
                y += 1;
            }
        }
        return grid;
    }

    boolean isValid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}