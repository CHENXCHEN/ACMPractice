package leetcode.normal.j734;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/network-delay-time/description/">743. 网络延迟时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<int[]>[] edges;

    public int networkDelayTime(int[][] times, int n, int k) {
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] time : times) {
            int u = time[0] - 1, v = time[1] - 1, w = time[2];
            edges[u].add(new int[]{v, w});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        bfs(k - 1, dis);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dis[i] == -1) return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }

    void bfs(int k, int[] dis) {
        dis[k] = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(k);
        while (!deque.isEmpty()) {
            Integer cur = deque.poll();
            for (int[] nxt : edges[cur]) {
                int to = nxt[0], w = nxt[1];
                if (dis[to] == -1 || dis[cur] + w < dis[to]) {
                    dis[to] = dis[cur] + w;
                    deque.add(to);
                }
            }
        }
    }
}