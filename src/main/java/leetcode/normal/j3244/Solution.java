package leetcode.normal.j3244;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/">3244. 新增道路查询后的最短距离 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // roads[i] 表示 i 到达的下一个点
        int[] roads = new int[n];
        for (int i = 0; i < n; i++) roads[i] = i + 1;
        int[] ans = new int[queries.length];
        int dist = n - 1;
        for (int i = 0; i < queries.length; i++) {
            int k = roads[queries[i][0]];
            roads[queries[i][0]] = queries[i][1];
            // 将两点之间的边都删去
            while (k != -1 && k < queries[i][1]) {
                int t = roads[k];
                roads[k] = -1;
                k = t;
                dist--;
            }
            ans[i] = dist;
        }
        return ans;
    }
}