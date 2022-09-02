package leetcode.normal.j687;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/longest-univalue-path/">687. 最长同值路径</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int cur = findMaxVal(root.left, root.val) + findMaxVal(root.right, root.val);
        return Math.max(cur, Math.max(dfs(root.left), dfs(root.right)));
    }

    int findMaxVal(TreeNode root, int vv) {
        if (root == null || root.val != vv) return 0;
        return Math.max(findMaxVal(root.left, vv), findMaxVal(root.right, vv)) + 1;
    }
}