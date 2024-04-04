package leetcode.normal.j2192;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/">2192. 有向无环图中一个节点的所有祖先</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] _edges) {
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        int[] du = new int[n];
        for (int[] e : _edges) {
            int u = e[0], v = e[1];
            edges[u].add(v);
            du[v]++;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Set<Integer>> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (du[i] == 0) deque.add(i);
            ans.add(new TreeSet<>());
        }
        while (!deque.isEmpty()) {
            Integer now = deque.poll();
            for (Integer to : edges[now]) {
                --du[to];
                ans.get(to).add(now);
                ans.get(to).addAll(ans.get(now));
                if (du[to] == 0) {
                    deque.push(to);
                }
            }
        }
        for (Set<Integer> ss : ans) {
            res.add(new ArrayList<>(ss));
        }
        return res;
    }
}