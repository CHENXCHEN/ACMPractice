package leetcode.normal.j965;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/univalued-binary-tree/
 * 965. 单值二叉树
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        if (!isUnivalTree(root.left)) {
            return false;
        }
        return isUnivalTree(root.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}