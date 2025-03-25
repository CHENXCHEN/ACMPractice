package leetcode.normal.j2711;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/difference-of-number-of-distinct-values-on-diagonals/description/">2711. 对角线上不同值的数量差</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<Integer>[][] topLeft = new HashSet[rows][cols], bottomRight = new HashSet[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                topLeft[i][j] = new HashSet<>();
                if (i - 1 >= 0 && j - 1 >= 0) {
                    topLeft[i][j].addAll(topLeft[i - 1][j - 1]);
                }
                topLeft[i][j].add(grid[i][j]);
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                bottomRight[i][j] = new HashSet<>();
                if (i + 1 < rows && j + 1 < cols) {
                    bottomRight[i][j].addAll(bottomRight[i + 1][j + 1]);
                }
                bottomRight[i][j].add(grid[i][j]);
            }
        }
        int[][] ans = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int top = (i - 1 >= 0 && j - 1 >= 0) ? topLeft[i - 1][j - 1].size() : 0;
                int bottom = (i + 1 < rows && j + 1 < cols) ? bottomRight[i + 1][j + 1].size() : 0;
                ans[i][j] = Math.abs(top - bottom);
            }
        }
        return ans;
    }
}