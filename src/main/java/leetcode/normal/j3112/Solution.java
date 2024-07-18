package leetcode.normal.j3112;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-time-to-visit-disappearing-nodes/description/">3112. 访问消失节点的最少时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] minimumTime(int n, int[][] _edges, int[] disappear) {
        ArrayList<int[]>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] e : _edges) {
            int u = e[0], v = e[1], w = e[2];
            edges[u].add(new int[]{v, w});
            edges[v].add(new int[]{u, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        pq.add(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int now = poll[1];
            int nowVal = poll[0];
            if (nowVal != ans[now]) continue;
            for (int[] e : edges[now]) {
                int v = e[0], w = e[1];
                if (nowVal + w < disappear[v] && (nowVal + w < ans[v] || ans[v] == -1)) {
                    ans[v] = nowVal + w;
                    pq.add(new int[]{ans[v], v});
                }
            }
        }
        return ans;
    }
}