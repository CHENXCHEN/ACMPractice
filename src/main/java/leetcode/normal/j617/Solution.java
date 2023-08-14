package leetcode.normal.j617;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/">617. 合并二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode root = new TreeNode();
        merge(root, root1, root2);
        return root;
    }

    void merge(TreeNode root, TreeNode root1, TreeNode root2) {
        if (root1 != null) root.val += root1.val;
        if (root2 != null) root.val += root2.val;
        TreeNode left1 = getLeft(root1), left2 = getLeft(root2), right1 = getRight(root1), right2 = getRight(root2);
        if (left1 != null || left2 != null) {
            root.left = new TreeNode();
            merge(root.left, left1, left2);
        }
        if (right1 != null || right2 != null) {
            root.right = new TreeNode();
            merge(root.right, right1, right2);
        }
    }

    TreeNode getLeft(TreeNode root) {
        return root == null ? null : root.left;
    }

    TreeNode getRight(TreeNode root) {
        return root == null ? null : root.right;
    }
}