package leetcode.normal.j1857;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-color-value-in-a-directed-graph/description/">1857. 有向图中最大颜色值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int largestPathValue(String colors, int[][] _edges) {
        int n = colors.length();
        int[] ru = new int[n];
        ArrayList<Integer>[] edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] e : _edges) {
            edges[e[0]].add(e[1]);
            ++ru[e[1]];
        }
        int[][] dp = new int[n][26];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (ru[i] == 0) {
                dp[i][colors.charAt(i) - 'a']++;
                deque.add(i);
            }
        }
        while (!deque.isEmpty()) {
            Integer u = deque.poll();
            for (Integer v : edges[u]) {
                --ru[v];
                for (int i = 0; i < 26; i++) {
                    dp[v][i] = Math.max(dp[v][i], dp[u][i]);
                }
                if (ru[v] == 0) {
                    dp[v][colors.charAt(v) - 'a']++;
                    deque.add(v);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ru[i] > 0) return -1;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (dp[i][j] > 0 && dp[i][j] > ans) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }
}