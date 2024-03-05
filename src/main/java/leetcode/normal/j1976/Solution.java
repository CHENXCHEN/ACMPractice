package leetcode.normal.j1976;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/description/">1976. 到达目的地的方案数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000000 + 7;
        long[] dis = new long[n];
        int[] cnt = new int[n];
        ArrayList<int[]>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] road : roads) {
            int u = road[0], v = road[1];
            edges[u].add(new int[]{v, road[2]});
            edges[v].add(new int[]{u, road[2]});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
        pq.add(new long[]{0, 0});
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        cnt[0] = 1;
        while (!pq.isEmpty()) {
            long[] poll = pq.poll();
            int u = (int) poll[1];
            long cur = poll[0];
            if (cur > dis[u]) continue;
            for (int[] next : edges[u]) {
                int v = next[0], w = next[1];
                if (cur + w < dis[v]) {
                    dis[v] = cur + w;
                    cnt[v] = cnt[u];
                    pq.add(new long[]{dis[v], v});
                } else if (cur + w == dis[v]) {
                    cnt[v] = (cnt[v] + cnt[u]) % mod;
                }
            }
        }
        return cnt[n - 1];
    }
}