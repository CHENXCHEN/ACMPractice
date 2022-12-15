package leetcode.normal.j1697;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/description/">1697. 检查边长度限制的路径是否存在</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (x, y) -> x[2] - y[2]);
        Integer[] qPos = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) qPos[i] = i;
        Arrays.sort(qPos, (a, b) -> queries[a][2] - queries[b][2]);
        boolean[] ans = new boolean[queries.length];
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0, j = 0; i < queries.length; i++) {
            int[] query = queries[qPos[i]];
            while (j < edgeList.length && edgeList[j][2] < query[2]) {
                union(edgeList[j][0], edgeList[j][1]);
                ++j;
            }
            ans[qPos[i]] = find(query[0]) == find(query[1]);
        }
        return ans;
    }

    int find(int fa) {
        if (parent[fa] == fa) return fa;
        return parent[fa] = find(parent[fa]);
    }

    void union(int fa, int fb) {
        int pa = find(fa), pb = find(fb);
        parent[pb] = pa;
    }
}