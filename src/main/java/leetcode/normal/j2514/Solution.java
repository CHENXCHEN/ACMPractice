package leetcode.normal.j2514;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/U7WvvU/">LCP 64. 二叉树灯饰</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int closeLampInTree(TreeNode root) {
        return dfs(root)[0];
    }

    int[] dfs(TreeNode root) {
        // dp[0] => 全灭的最小次数
        // dp[1] => 根亮，其他灭的最小次数
        // dp[2] => 全亮的最小次数
        // dp[3] => 根灭，其他亮的最小次数
        int[] dp = new int[]{0, 0, 0, 0};
        if (root == null) return dp;
        int[] left = dfs(root.left), right = dfs(root.right);
        int v = root.val, rv = root.val == 1 ? 0 : 1;
        // 全灭的最小次数
        dp[0] = min(left[0] + right[0] + v, left[1] + right[1] + rv + 1, left[2] + right[2] + rv + 1, left[3] + right[3] + v + 2);
        // 根亮，其他灭的最小次数
        dp[1] = min(left[0] + right[0] + rv, left[1] + right[1] + v + 1, left[2] + right[2] + v + 1, left[3] + right[3] + rv + 2);
        // 全亮的最小次数
        dp[2] = min(left[0] + right[0] + v + 1, left[1] + right[1] + rv + 2, left[2] + right[2] + rv, left[3] + right[3] + v + 1);
        // 根灭，其他亮
        dp[3] = min(left[0] + right[0] + rv + 1, left[1] + right[1] + v + 2, left[2] + right[2] + v, left[3] + right[3] + rv + 1);
        return dp;
    }

    int min(int a, int b, int c, int d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}