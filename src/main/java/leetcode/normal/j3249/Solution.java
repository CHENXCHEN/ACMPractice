package leetcode.normal.j3249;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-the-number-of-good-nodes/description/">3249. 统计好节点的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Integer>[] edges;
    int ans;

    public int countGoodNodes(int[][] _edges) {
        int n = _edges.length + 1;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] e : _edges) {
            int u = e[0], v = e[1];
            edges[u].add(v);
            edges[v].add(u);
        }
        ans = 0;
        dfs(0, 0);
        return ans;
    }

    int dfs(int cur, int parent) {
        int cnt = 0, last = -1;
        boolean check = true;
        for (Integer to : edges[cur]) {
            if (to != parent) {
                int childCnt = dfs(to, cur);
                cnt += childCnt;
                if (last == -1) last = childCnt;
                else if (last != childCnt) check = false;
            }
        }
        if (check) ++ans;
        return cnt + 1;
    }
}