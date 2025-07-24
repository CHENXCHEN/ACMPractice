package leetcode.normal.j2322;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/minimum-score-after-removals-on-a-tree/description/">2322. 从树中删除边的最小分数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    ArrayList<Integer>[] edges;
    int allXor = 0, ans = Integer.MAX_VALUE;
    int[] nums;

    public int minimumScore(int[] nums, int[][] _edges) {
        int n = nums.length;
        edges = new ArrayList[n];
        this.nums = nums;
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] e : _edges) {
            edges[e[0]].add(e[1]);
            edges[e[1]].add(e[0]);
        }
        allXor = 0;
        for (int i = 0; i < n; i++) {
            allXor ^= nums[i];
        }
        dfs(0, -1);
        return ans;
    }

    int dfs(int u, int p) {
        int son = nums[u];
        for (Integer v : edges[u]) {
            if (v == p) continue;
            son ^= dfs(v, u);
        }

        if (p != -1) dfs2(p, u, son, u);
        return son;
    }

    int dfs2(int u, int p, int son1, int anc) {
        int son2 = nums[u];
        for (Integer v : edges[u]) {
            if (v == p) continue;
            son2 ^= dfs2(v, u, son1, anc);
        }
        if (p == anc) return son2;
        ans = Math.min(ans, calc(son1, son2, allXor ^ son1 ^ son2));
        return son2;
    }

    int calc(int part1, int part2, int part3) {
        int max = Math.max(part1, Math.max(part2, part3));
        int min = Math.min(part1, Math.min(part2, part3));
        return max - min;
    }

}