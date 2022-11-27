package leetcode.normal.j882;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/">882. 细分图中的可到达节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<int[]>[] edges;
    int maxMoves, ans;

    public int reachableNodes(int[][] _edges, int maxMoves, int n) {
        this.maxMoves = maxMoves;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        // 构建图
        for (int[] edge : _edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];
            edges[u].add(new int[]{v, cnt});
            edges[v].add(new int[]{u, cnt});
        }
        // 标识某条边 u -> v，走了多少个点
        Map<Pair<Integer, Integer>, Integer> edgeHas = new HashMap<>();
        // 走到某个点花了多少步
        boolean[] vis = new boolean[n + 1];
        // 一共走了多少个点
        ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] nowPair = pq.poll();
            int now = nowPair[1];
            if (vis[now]) continue;
            vis[now] = true;
            ++ans;
            int nowStep = nowPair[0];
            for (int[] next : edges[now]) {
                Pair<Integer, Integer> nowToNextEdge = new Pair<>(now, next[0]);
                Pair<Integer, Integer> nextToNowEdge = new Pair<>(next[0], now);
                // 这条边最多可以走几个点
                int canMove = Math.min(maxMoves - nowStep, next[1] - edgeHas.getOrDefault(nowToNextEdge, 0) - edgeHas.getOrDefault(nextToNowEdge, 0));
                int nextStep = nowStep + next[1] + 1;
                ans += canMove;
                // 更新这条边走了多少个点
                if (canMove > 0)
                    edgeHas.put(nowToNextEdge, edgeHas.getOrDefault(nowToNextEdge, 0) + canMove);
                if (nextStep <= maxMoves && !vis[next[0]]) {
                    // 如果这条边完全可以走完，那么看看是否可以多走一步到下一个点
                    pq.add(new int[]{nextStep, next[0]});
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{0, 1, 10}, {0, 2, 1}, {1, 2, 2}};
        solution.reachableNodes(edges, 6, 3);
    }
}