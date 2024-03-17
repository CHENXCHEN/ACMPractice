package leetcode.normal.j310;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-height-trees/description/">310. 最小高度树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution2 {
    ArrayList<Integer>[] edges;

    public List<Integer> findMinHeightTrees(int n, int[][] _edges) {
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] e : _edges) {
            int u = e[0], v = e[1];
            edges[u].add(v);
            edges[v].add(u);
        }
        int[] parent = new int[n];
        int node = longest(0, parent);
        int mxNode = longest(node, parent);
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        int x = mxNode;
        while (x >= 0) {
            path.add(x);
            x = parent[x];
        }
        int size = path.size();
        if ((size & 1) == 0) {
            ans.add(path.get((size >> 1) - 1));
        }
        ans.add(path.get(size >> 1));
        return ans;
    }

    int longest(int start, int[] parent) {
        Arrays.fill(parent, -1);
        parent[start] = -2;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        int last = start;
        while (!deque.isEmpty()) {
            int now = deque.poll();
            last = now;
            for (Integer to : edges[now]) {
                if (parent[to] == -1) {
                    parent[to] = now;
                    deque.add(to);
                }
            }
        }
        return last;
    }
}
