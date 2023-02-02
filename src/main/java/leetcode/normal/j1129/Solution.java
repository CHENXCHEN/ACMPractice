package leetcode.normal.j1129;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/shortest-path-with-alternating-colors/">1129. 颜色交替的最短路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[][] edges = new ArrayList[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++)
                edges[i][j] = new ArrayList<>();
        }
        for (int[] redEdge : redEdges) {
            edges[redEdge[0]][0].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            edges[blueEdge[0]][1].add(blueEdge[1]);
        }
        // dis[i][0] -> 通过红色边到达 i 点时的最小值
        // dis[i][1] -> 通过蓝色边到达 i 点时的最小值
        int[][] dis = new int[n][2];
        for (int i = 0; i < n; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        Arrays.fill(dis[0], 0);
        ArrayDeque<Pair<Integer, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(0, 0));
        deque.add(new Pair<>(0, 1));
        while (!deque.isEmpty()) {
            Pair<Integer, Integer> cur = deque.poll();
            int nowNum = cur.getKey(), nowColor = cur.getValue(), nextColor = nowColor ^ 1;
            int nextDis = dis[nowNum][nowColor] + 1;
            for (Integer to : edges[cur.getKey()][nextColor]) {
                if (dis[to][nextColor] > nextDis) {
                    dis[to][nextColor] = nextDis;
                    deque.add(new Pair<>(to, nextColor));
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dis[i][0], dis[i][1]);
            if (ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }
        return ans;
    }
}