package leetcode.normal.j2477;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/description/">2477. 到达首都的最少油耗</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long[][] res;
    boolean[] vis;
    int seats;
    ArrayList<Integer>[] edges;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();
        for (int[] road : roads) {
            edges[road[0]].add(road[1]);
            edges[road[1]].add(road[0]);
        }
        // res[i][0] -> 有多少辆满载的车
        // res[i][1] -> 有1辆不满载的车，上面的人数
        // res[i][2] -> 到这个节点一共花了多少汽油
        res = new long[n][3];
        vis = new boolean[n];
        this.seats = seats;
        dfs(0);
        return res[0][2];
    }

    void dfs(int cur) {
        if (vis[cur]) return;
        vis[cur] = true;
        int emptyCar = 0;
        for (Integer to : edges[cur]) {
            if (!vis[to]) {
                dfs(to);
                res[cur][0] += res[to][0];
                if (res[to][1] > 0) ++emptyCar;
                res[cur][1] += res[to][1];
                res[cur][2] += res[to][2];
            }
        }
        res[cur][2] += res[cur][0] + emptyCar;
        ++res[cur][1];
        // 没坐满的车上的人看看最少能凑多少车
        res[cur][0] += res[cur][1] / seats;
        // 剩下的人坐一辆车
        res[cur][1] = res[cur][1] % seats;
    }
}