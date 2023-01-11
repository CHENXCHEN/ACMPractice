package leetcode.normal.j753;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    Set<Integer> seen = new HashSet<Integer>();
    StringBuffer ans = new StringBuffer();
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        this.k = k;
        // 如果从 u -> ... -> u 走到底后没有路了，但是有一些节点有的边没有走，
        // 比如 v，那么我们可以从 v 开始走出一段路 v -> ... -> v
        // 再拼接起来 u -> ... -> v -> ... -> v -> ... -> u 即可
        // 使用回溯的技巧，类后续遍历来拼接即可
        dfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    public void dfs(int node) {
        for (int x = 0; x < k; ++x) {
            int nei = node * 10 + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei % highest);
                ans.append(x);
            }
        }
    }
}