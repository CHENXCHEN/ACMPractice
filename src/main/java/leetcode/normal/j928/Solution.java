package leetcode.normal.j928;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimize-malware-spread-ii/description/">928. 尽量减少恶意软件的传播 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    edges[i].add(j);
                    edges[j].add(i);
                }
            }
        }
        int ans = n + 1, lastDirty = Integer.MAX_VALUE;
        boolean[] vis = new boolean[n];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int u : initial) {
            Arrays.fill(vis, false);
            vis[u] = true;
            int dirtyCnt = 0;
            for (int to : initial) {
                if (u != to) {
                    vis[to] = true;
                    deque.push(to);
                }
            }
            while (!deque.isEmpty()) {
                int cur = deque.pop();
                ++dirtyCnt;
                for (Integer to : edges[cur]) {
                    if (!vis[to]) {
                        vis[to] = true;
                        deque.push(to);
                    }
                }
            }
            if (dirtyCnt < lastDirty || (dirtyCnt == lastDirty && u < ans)) {
                ans = u;
                lastDirty = dirtyCnt;
            }
        }
        return ans;
    }

}