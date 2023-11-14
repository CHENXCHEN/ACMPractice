package leetcode.normal.j1334;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/">1334. 阈值距离内邻居最少的城市</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int findTheCity(int n, int[][] _edges, int distanceThreshold) {
        ArrayList<Pair<Integer, Integer>>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] edge : _edges) {
            edges[edge[0]].add(new Pair<>(edge[1], edge[2]));
            edges[edge[1]].add(new Pair<>(edge[0], edge[2]));
        }
        int cnt = Integer.MAX_VALUE, pos = 0;
        for (int i = 0; i < n; i++) {
            int bfs = bfs(edges, i, distanceThreshold);
            if (bfs <= cnt) {
                cnt = bfs;
                pos = i;
            }
        }
        return pos;
    }

    int bfs(ArrayList<Pair<Integer, Integer>>[] edges, int start, int disThreshold) {
        int[] vis = new int[edges.length];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        Arrays.fill(vis, Integer.MAX_VALUE);
        vis[start] = 0;
        int ans = 0;
        while (!deque.isEmpty()) {
            Integer now = deque.poll();
            for (Pair<Integer, Integer> next : edges[now]) {
                int nextDis = vis[now] + next.getValue();
                if (nextDis <= disThreshold && nextDis < vis[next.getKey()]) {
                    if (vis[next.getKey()] == Integer.MAX_VALUE) ++ans;
                    vis[next.getKey()] = nextDis;
                    deque.add(next.getKey());
                }
            }
        }
        return ans;
    }
}