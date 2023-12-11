package leetcode.normal.j1631;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/path-with-minimum-effort/description/">1631. 最小体力消耗路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length, tot = rows * cols;
        parent = new int[tot];
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 0; i < tot; i++) parent[i] = i;
        int[][] dir = {{-1, 0}, {0, -1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int now = i * cols + j;
                for (int k = 0; k < dir.length; k++) {
                    int px = i + dir[k][0], py = j + dir[k][1];
                    int pre = px * cols + py;
                    if (px >= 0 && py >= 0) {
                        edges.add(new int[]{pre, now, Math.abs(heights[i][j] - heights[px][py])});
                    }
                }
            }
        }
        edges.sort((x, y) -> Integer.compare(x[2], y[2]));
        int start = 0, end = rows * cols - 1, ans = 0;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            ans = Math.max(ans, edge[2]);
            if (find(start) == find(end)) {
                break;
            }
        }
        return ans;
    }

    void union(int x, int y) {
        int px = find(x), py = find(y);
        parent[px] = py;
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
}