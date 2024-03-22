package leetcode.normal.j2617;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/description/">2617. 网格图中最少访问的格子数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        PriorityQueue<int[]>[] priorRows = new PriorityQueue[rows];
        PriorityQueue<int[]>[] priorCols = new PriorityQueue[cols];
        for (int i = 0; i < rows; i++) priorRows[i] = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        for (int j = 0; j < cols; j++) priorCols[j] = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        int[][] dis = new int[rows][cols];
        for (int i = 0; i < rows; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                PriorityQueue<int[]> pRow = priorRows[i], pCol = priorCols[j];
                while (!pRow.isEmpty() && pRow.peek()[1] + grid[i][pRow.peek()[1]] < j) {
                    pRow.poll();
                }
                if (!pRow.isEmpty()) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][pRow.peek()[1]] + 1);
                }

                while (!pCol.isEmpty() && pCol.peek()[1] + grid[pCol.peek()[1]][j] < i) {
                    pCol.poll();
                }
                if (!pCol.isEmpty()) {
                    dis[i][j] = Math.min(dis[i][j], dis[pCol.peek()[1]][j] + 1);
                }
                if (dis[i][j] != Integer.MAX_VALUE) {
                    pRow.offer(new int[]{dis[i][j], j});
                    pCol.offer(new int[]{dis[i][j], i});
                }
            }
        }
        return dis[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dis[rows - 1][cols - 1];
    }
}