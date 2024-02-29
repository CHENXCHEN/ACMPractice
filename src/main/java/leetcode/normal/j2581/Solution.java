package leetcode.normal.j2581;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-number-of-possible-root-nodes/description/">2581. 统计可能的树根数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    Set<Long> ss;
    ArrayList<Integer>[] edges;
    int cnt, res, k;

    public int rootCount(int[][] _edges, int[][] guesses, int k) {
        ss = new HashSet<>();
        this.k = k;
        int n = _edges.length + 1;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] edge : _edges) {
            edges[edge[0]].add(edge[1]);
            edges[edge[1]].add(edge[0]);
        }
        for (int[] guess : guesses) {
            ss.add(h(guess[0], guess[1]));
        }
        cnt = res = 0;
        dfs(0, -1);
        rdfs(0, -1, cnt);
        return res;
    }

    void dfs(int x, int parent) {
        for (Integer y : edges[x]) {
            if (y == parent) continue;
            cnt += ss.contains(h(x, y)) ? 1 : 0;
            dfs(y, x);
        }
    }

    void rdfs(int x, int parent, int cnt) {
        if (cnt >= k) ++res;
        for (Integer y : edges[x]) {
            if (y == parent) continue;
            rdfs(y, x, cnt - (ss.contains(h(x, y)) ? 1 : 0) + (ss.contains(h(y, x)) ? 1 : 0));
        }
    }

    long h(int x, int y) {
        return ((long) x << 20) | y;
    }
}