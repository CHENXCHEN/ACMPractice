package leetcode.normal.j685;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/redundant-connection-ii/description/">685. 冗余连接 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        // vis[i] 记录节点 i 的父节点是哪个
        int[] vis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            vis[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            // 如果 v 有两个父节点，那么当前边是冲突的
            if (vis[v] != v) {
                conflict = i;
            } else {
                vis[v] = u;
                // 如果 u 和 v 是在同一集合内，说明形成环路
                if (find(u) == find(v)) {
                    cycle = i;
                } else {
                    union(u, v);
                }
            }
        }
        if (conflict < 0) {
            // 如果只找到环
            return new int[]{edges[cycle][0], edges[cycle][1]};
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                // 如果既有冲突，又有环，那么删去冲突的那条边
                return new int[]{vis[conflictEdge[1]], conflictEdge[1]};
            } else {
                // 如果只有冲突
                return conflictEdge;
            }
        }
    }

    int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}