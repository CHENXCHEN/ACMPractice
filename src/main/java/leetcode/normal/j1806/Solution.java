package leetcode.normal.j1806;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-number-of-operations-to-reinitialize-a-permutation/">1806. 还原排列的最少操作步数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] parent;

    public int reinitializePermutation(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            int to = (i & 1) == 0 ? (i >> 1) : ((n >> 1) + ((i - 1) >> 1));
            union(i, to);
        }
        int[] vis = new int[n];
        int mx = 1;
        for (int i = 0; i < n; i++)
            mx = Math.max(mx, ++vis[find(i)]);
        return mx;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int fx = find(x), fy = find(y);
        parent[fx] = fy;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.reinitializePermutation(2);
    }
}