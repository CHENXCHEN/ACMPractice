package leetcode.normal.j1617;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/">1617. 统计子树中城市之间最大距离</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int n, mask, maxDis;
    ArrayList<Integer>[] edges;

    public int[] countSubgraphsForEachDiameter(int n, int[][] _edges) {
        this.n = n;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] _edge : _edges) {
            int x = _edge[0] - 1;
            int y = _edge[1] - 1;
            edges[x].add(y);
            edges[y].add(x);
        }
        int[] ans = new int[n - 1];
        int tot = 1 << n;
        for (int i = 1; i < tot; i++) {
            int start = 32 - Integer.numberOfLeadingZeros(i) - 1;
            mask = i;
            maxDis = 0;
            dfs(start);
            if (mask == 0 && maxDis > 0) {
                ans[maxDis - 1]++;
            }

        }
        return ans;
    }

    int dfs(int start) {
        int first = 0, second = 0;
        mask ^= (1 << start);
        for (Integer next : edges[start]) {
            if ((mask & (1 << next)) != 0) {
                int dis = 1 + dfs(next);
                if (dis > first) {
                    second = first;
                    first = dis;
                } else if (dis > second) {
                    second = dis;
                }
            }
        }
        maxDis = Math.max(maxDis, first + second);
        return first;
    }
}