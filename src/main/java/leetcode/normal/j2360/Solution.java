package leetcode.normal.j2360;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-cycle-in-a-graph/description/">2360. 图中的最长环</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int tot, ans;
    int[] mark, edges;

    public int longestCycle(int[] edges) {
        this.edges = edges;
        tot = 0;
        mark = new int[edges.length];
        ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (mark[i] == 0) dfs(i, new ArrayDeque<>());
        }
        return ans;
    }

    void dfs(int cur, ArrayDeque<Integer> stack) {
        if (mark[cur] != 0) {
            return;
        }
        mark[cur] = ++tot;
        stack.push(cur);
        int next = edges[cur];
        if (next < 0) return;
        if (mark[next] != 0) {
            int cnt = 0;
            while (!stack.isEmpty() && stack.peek() != next) {
                ++cnt;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == next) {
                ++cnt;
                stack.poll();
            } else {
                cnt = 0;
            }
            if (cnt > 0) {
                ans = Math.max(ans, cnt);
            }
        } else {
            dfs(next, stack);
        }
    }
}