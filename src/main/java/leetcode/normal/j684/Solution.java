package leetcode.normal.j684;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/redundant-connection/description/">684. 冗余连接</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        int[] ans = new int[2];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            int pu = find(u), pv = find(v);
            if (pu == pv) {
                ans = edge;
                break;
            }
            parent[pv] = pu;
        }
        return ans;
    }

    int find(int p) {
        return parent[p] == p ? p : (parent[p] = find(parent[p]));
    }
}