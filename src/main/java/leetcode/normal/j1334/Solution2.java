package leetcode.normal.j1334;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/">1334. 阈值距离内邻居最少的城市</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public int findTheCity(int n, int[][] _edges, int distanceThreshold) {
        int[][] edges = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(edges[i], Integer.MAX_VALUE);
        }
        for (int[] edge : _edges) {
            edges[edge[0]][edge[1]] = edges[edge[1]][edge[0]] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            edges[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n && edges[i][k] != Integer.MAX_VALUE; j++) {
                    if (edges[k][j] != Integer.MAX_VALUE) {
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                    }
                }
            }
        }
        int cnt = Integer.MAX_VALUE, pos = 0;
        for (int i = 0; i < n; i++) {
            int curCnt = 0;
            for (int j = 0; j < n; j++) {
                if (edges[i][j] <= distanceThreshold) ++curCnt;
            }
            if (curCnt <= cnt) {
                cnt = curCnt;
                pos = i;
            }
        }
        return pos;
    }
}