package leetcode.normal.j2646;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/description/">2646. 最小化旅行的价格总和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Integer>[] ed;
    int[] price, count;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        ed = new ArrayList[n];
        this.price = price;
        for (int i = 0; i < n; i++) ed[i] = new ArrayList<>();
        for (int[] edge : edges) {
            ed[edge[0]].add(edge[1]);
            ed[edge[1]].add(edge[0]);
        }
        count = new int[n];
        for (int[] trip : trips) {
            dfs(trip[0], -1, trip[1]);
        }
        int[] ans = dp(0, -1);
        return Math.min(ans[0], ans[1]);
    }

    boolean dfs(int cur, int parent, int end) {
        if (cur == end) {
            ++count[cur];
            return true;
        }
        for (Integer to : ed[cur]) {
            if (parent != to && dfs(to, cur, end)) {
                ++count[cur];
                return true;
            }
        }
        return false;
    }

    int[] dp(int cur, int parent) {
        // res[0] -> 当前节点不减半
        // res[1] -> 当前节点减半
        int[] res = {price[cur] * count[cur], price[cur] / 2 * count[cur]};
        for (Integer to : ed[cur]) {
            if (to != parent) {
                int[] child = dp(to, cur);
                res[0] += Math.min(child[0], child[1]);
                res[1] += child[0];
            }
        }
        return res;
    }
}