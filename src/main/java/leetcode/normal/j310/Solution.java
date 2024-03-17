package leetcode.normal.j310;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-height-trees/description/">310. 最小高度树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] maxHeight;
    ArrayList<Integer>[] edges;
    int last;
    ArrayList<Integer> ans;
    TreeMap<Integer, Integer>[] tMap;

    public List<Integer> findMinHeightTrees(int n, int[][] _edges) {
        maxHeight = new int[n];
        edges = new ArrayList[n];
        tMap = new TreeMap[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] e : _edges) {
            int u = e[0], v = e[1];
            edges[u].add(v);
            edges[v].add(u);
        }
        solveNodeMinHeight(0, -1);
        last = Integer.MAX_VALUE;
        ans = new ArrayList<>();
        solve(0, -1, -1);
        return ans;
    }

    int solveNodeMinHeight(int cur, int parent) {
        int height = 0;
        for (Integer to : edges[cur]) {
            if (to == parent) continue;
            height = Math.max(height, solveNodeMinHeight(to, cur) + 1);
        }
        maxHeight[cur] = height;
        return height;
    }

    void solve(int cur, int parent, int pMaxHeight) {
        int height = pMaxHeight + 1;
        int res = Math.max(height, maxHeight[cur]);
        if (res < last) {
            last = res;
            ans.clear();
        }
        if (res == last) ans.add(cur);
        TreeMap<Integer, Integer> curMap = tMap[cur];
        if (curMap == null) {
            curMap = new TreeMap<>();
            for (Integer to : edges[cur]) {
                if (to == parent) continue;
                curMap.compute(maxHeight[to], (k, v) -> (v == null ? 0 : v) + 1);
            }
            tMap[cur] = curMap;
        }
        for (Integer to : edges[cur]) {
            if (to == parent) continue;
            int tmp = maxHeight[to];
            removeToCnt(curMap, tmp);
            int excludeChildMaxHeight = height;
            if (!curMap.isEmpty()) excludeChildMaxHeight = Math.max(height, curMap.lastKey() + 1);
            solve(to, cur, excludeChildMaxHeight);
            addToCnt(curMap, tmp);
        }
    }

    void addToCnt(TreeMap<Integer, Integer> tMap, int height) {
        tMap.compute(height, (k, v) -> (v == null ? 0 : v) + 1);
    }

    void removeToCnt(TreeMap<Integer, Integer> tMap, int height) {
        Integer x = tMap.get(height);
        if (x == 1) tMap.remove(height);
        else tMap.put(height, x - 1);
    }
}