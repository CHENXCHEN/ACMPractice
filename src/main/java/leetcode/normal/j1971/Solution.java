package leetcode.normal.j1971;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/find-if-path-exists-in-graph/">1971. 寻找图中是否存在路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }

    int find(int fa) {
        if (fa != parent[fa])
            parent[fa] = find(parent[fa]);
        return parent[fa];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        parent[pa] = pb;
    }
}