package leetcode.normal.j2316;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/">2316. 统计无向图中无法互相到达点对数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] edge : edges) {
            parent[find(edge[0])] = parent[find(edge[1])];
        }
        for (int i = 0; i < n; i++) find(i);
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) cnt[find(i)]++;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] > 0) res.add(cnt[i]);
        }
        long ans = 0L;
        int sum = res.get(0);
        for (int i = 1; i < res.size(); i++) {
            ans += (long) sum * res.get(i);
            sum += res.get(i);
        }
        return ans;
    }

    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}