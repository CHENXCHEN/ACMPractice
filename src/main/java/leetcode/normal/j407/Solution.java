package leetcode.normal.j407;

import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/trapping-rain-water-ii/description/">407. 接雨水 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int rows = heightMap.length, cols = heightMap[0].length;
        if (rows <= 2 || cols <= 2) return 0;
        // 1. 边框无法接水 2. 一个方块可以接的水，由四周最小的高度和当前的高度所决定
        // 枚举一个方块接水之后的高度(本身高度 + 接的水的高度)，从小到大枚举
        boolean[][] visited = new boolean[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int ans = 0;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0], y = top[1], water = top[2];
            for (int[] d : dir) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                    // water 是当前 (nx,ny) 方块四周最低的高度
                    if (water >= heightMap[nx][ny]) {
                        ans += water - heightMap[nx][ny];
                    }
                    pq.offer(new int[]{nx, ny, Math.max(heightMap[nx][ny], water)});
                    visited[nx][ny] = true;
                }
            }
        }
        return ans;
    }
}