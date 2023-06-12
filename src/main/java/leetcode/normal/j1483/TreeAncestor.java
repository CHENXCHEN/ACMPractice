package leetcode.normal.j1483;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/"></a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class TreeAncestor {
    // 数据范围最大为 5*10^4，不超过 2^16
    int maxLevel = 16;
    // dp[i][j] 表示为节点 i 的向上 2^j 条到达的节点是哪个，-1 则代表超过了
    // dp[i][j] 节点可以通过看做 i 节点向上跳了 2^(j-1)，再在这个节点基础上再跳 2^(j-1)
    int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][maxLevel];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        for (int i = 1; i < n; i++) {
            dp[i][0] = parent[i];
        }
        for (int j = 1; j < maxLevel; j++) {
            for (int i = 1; i < n; i++) {
                if (dp[i][j - 1] != -1) {
                    // dp[i][j] 节点可以通过看做 i 节点向上跳了 2^(j-1)，再在这个节点基础上再跳 2^(j-1)
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < maxLevel; i++) {
            if (((k >> i) & 1) == 1) {
                node = dp[node][i];
                if (node == -1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */