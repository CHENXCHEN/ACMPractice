package leetcode.normal.j3243;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i/">3243. 新增道路查询后的最短距离 I</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] dis;
    ArrayList<Integer>[] edges;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        dis = new int[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) edges[i].add(i + 1);
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        bfs(0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int u = query[0], v = query[1];
            edges[u].add(v);
            bfs(u);
            ans[i] = dis[n - 1];
        }
        return ans;
    }

    void bfs(int start) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while (!deque.isEmpty()) {
            Integer now = deque.poll();
            for (Integer to : edges[now]) {
                if (dis[now] + 1 < dis[to]) {
                    dis[to] = dis[now] + 1;
                    deque.add(to);
                }
            }
        }
    }
}