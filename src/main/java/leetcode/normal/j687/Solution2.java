package leetcode.normal.j687;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-univalue-path/">687. 最长同值路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = dfs(root.left), maxRight = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.val == root.left.val) left1 = maxLeft + 1;
        if (root.right != null && root.val == root.right.val) right1 = maxRight + 1;
        ans = Math.max(ans, left1 + right1);
        return Math.max(left1, right1);
    }
}