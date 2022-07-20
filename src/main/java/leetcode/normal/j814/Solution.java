package leetcode.normal.j814;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-pruning/">814. 二叉树剪枝</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        if (root.left == null && root.right == null && root.val == 0) return null;
        return root;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftNum = dfs(root.left);
        int rightNum = dfs(root.right);
        if (leftNum == 0) root.left = null;
        if (rightNum == 0) root.right = null;
        return leftNum + rightNum + root.val;
    }
}