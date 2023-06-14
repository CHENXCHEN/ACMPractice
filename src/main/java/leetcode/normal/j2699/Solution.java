package leetcode.normal.j2699;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/modify-graph-edge-weights/">2699. 修改图中的边权</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int source, dest, target, n;
    int[][] edges;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int dest, int target) {
        // 我们需要修改的边数为 k，source -> dest 的最短路权值范围为：
        // [1,1,1,1,...,1] 时，最短路最小
        // [D,D,D,D,...,D] 时，最短路最大，D = target，因为如果超过 target，source -> dest 如果经过这条边，那它的最短路一定大于 target
        // 在以上两个边界之间的任意一个组合，如果任意一条边的权值 +1，那么它的最短路要么不变，要么 +1
        // 因此在 sum([1,1,1,1,...,1]) -> sum([D,D,D,D,...,D]) 之间的排列组合值中，它具有单调性，因此可以二分求解
        // 每条边的取值是 [1,D]，如果从 0 开始看的话，就是 [0,D-1]，k 条边的和最大为 k * (D - 1)
        // 在 [0, k * (D - 1)] 之间二分即可
        this.n = n;
        this.edges = edges;
        this.source = source;
        this.dest = dest;
        this.target = target;
        int k = 0;
        for (int[] e : edges) {
            if (e[2] == -1) ++k;
        }
        // 如果最小边权 [1,1,1,...,1] 都大于 target，那么一定没有答案
        if (dijkstra(source, dest, construct(0, target)) > target) {
            return new int[0][];
        }
        // 如果最大边权 [target,target,target,....,target] 都小于 target，那么一定没有答案
        if (dijkstra(source, dest, construct((long) k * (target - 1), target)) < target) {
            return new int[0][];
        }
        long left = 0, right = (long) k * (target - 1), ans = 0;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (dijkstra(source, dest, construct(mid, target)) >= target) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        for (int[] e : edges) {
            if (e[2] == -1) {
                if (ans >= target - 1) {
                    e[2] = target;
                    ans -= target - 1;
                } else {
                    e[2] = (int) ans + 1;
                    ans = 0;
                }
            }
        }
        return edges;
    }

    long dijkstra(int source, int dest, int[][] adjEdges) {
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        boolean[] used = new boolean[n];
        dist[source] = 0;
        for (int round = 0; round < n - 1; ++round) {
            // 找到到达从 source 出发，到达 i 的距离最小且没走过的那个点
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!used[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            used[u] = true;
            // 计算 u -> v 的距离，注意 v 点需要没有走过
            for (int v = 0; v < n; v++) {
                if (!used[v] && adjEdges[u][v] != -1) {
                    dist[v] = Math.min(dist[v], dist[u] + adjEdges[u][v]);
                }
            }
        }
        return dist[dest];
    }

    int[][] construct(long idx, int target) {
        // 构造新的边，边权之和不超过 idx，且每条边的边权为 [1,target]，为了通用处理，我们假定为 [0,target-1]，最终构造之后再 + 1
        int[][] adjEdges = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(adjEdges[i], -1);
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            if (w != -1) {
                adjEdges[u][v] = adjEdges[v][u] = w;
            } else {
                if (idx >= target - 1) {
                    // 如果超过 target - 1，那么我们就令这条边权为 target
                    adjEdges[u][v] = adjEdges[v][u] = target;
                    // 边权之和最大为 k * (target - 1)
                    idx -= target - 1;
                } else {
                    adjEdges[u][v] = adjEdges[v][u] = (int) (1 + idx);
                    idx = 0;
                }
            }
        }
        return adjEdges;
    }
}