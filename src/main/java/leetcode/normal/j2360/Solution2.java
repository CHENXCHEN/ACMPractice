package leetcode.normal.j2360;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-cycle-in-a-graph/description/">2360. 图中的最长环</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    int tot, ans;
    int[] mark, edges;

    public int longestCycle(int[] edges) {
        this.edges = edges;
        tot = 0;
        mark = new int[edges.length];
        ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (mark[i] == 0) dfs(i, tot);
        }
        return ans;
    }

    void dfs(int cur, int start) {
        if (mark[cur] != 0) {
            return;
        }
        mark[cur] = ++tot;
        int next = edges[cur];
        if (next < 0) return;
        if (mark[next] != 0) {
            if (mark[next] > start) {
                ans = Math.max(ans, mark[cur] - mark[next] + 1);
            }
        } else {
            dfs(next, start);
        }
    }
}