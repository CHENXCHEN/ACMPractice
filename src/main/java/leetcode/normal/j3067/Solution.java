package leetcode.normal.j3067;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-pairs-of-connectable-servers-in-a-weighted-tree-network/description/">3067. 在带权树网络中统计可连接服务器对数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<int[]>[] edges;

    public int[] countPairsOfConnectableServers(int[][] _edges, int signalSpeed) {
        int n = _edges.length + 1;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] e : _edges) {
            int u = e[0], v = e[1], w = e[2];
            edges[u].add(new int[]{v, w});
            edges[v].add(new int[]{u, w});
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> res = new ArrayList<>();
            int cnt = 0, sum = 0;
            for (int[] to : edges[i]) {
                int calc = dfs(to[0], i, to[1], signalSpeed);
                sum += calc;
                res.add(calc);
            }
            for (int j = 0; j < res.size(); j++) {
                sum -= res.get(j);
                cnt += res.get(j) * sum;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    int dfs(int u, int parent, int sum, int speed) {
        int cnt = 0;
        if (sum % speed == 0) cnt++;
        for (int[] to : edges[u]) {
            int v = to[0], w = to[1];
            if (v != parent) {
                cnt += dfs(v, u, sum + w, speed);
            }
        }
        return cnt;
    }
}