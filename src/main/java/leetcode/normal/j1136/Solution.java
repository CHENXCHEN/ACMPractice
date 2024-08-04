package leetcode.normal.j1136;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/parallel-courses/description/">1136. 并行课程</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        int[] du = new int[n + 1];
        for (int[] relation : relations) {
            int u = relation[0], v = relation[1];
            du[v]++;
            edges[u].add(v);
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (du[i] == 0) deque.add(new int[]{i, 1});
        }
        int ans = -1;
        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            int u = pop[0], step = pop[1];
            ans = Math.max(ans, step);
            for (Integer to : edges[u]) {
                --du[to];
                if (du[to] == 0) {
                    deque.add(new int[]{to, step + 1});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (du[i] != 0) return -1;
        }
        return ans;
    }
}