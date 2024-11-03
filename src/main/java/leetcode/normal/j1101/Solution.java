package leetcode.normal.j1101;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/the-earliest-moment-when-everyone-become-friends/description/">1101. 彼此熟识的最早时间</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int last = -1;
        for (int[] log : logs) {
            int u = log[1], v = log[2];
            if (find(u) != find(v)) {
                union(u, v);
                last = log[0];
            }
        }
        int cnt = 0, mk = find(0);
        for (int i = 0; i < n; i++) {
            if (mk == find(i)) ++cnt;
        }
        return cnt == n ? last : -1;
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx < fy) parent[fx] = fy;
        else parent[fy] = fx;
    }
}