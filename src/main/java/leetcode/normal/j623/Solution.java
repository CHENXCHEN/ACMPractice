package leetcode.normal.j623;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/add-one-row-to-tree/">623. 在二叉树中增加一行</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        insert(root, val, 1, depth);
        return root;
    }

    void insert(TreeNode root, int val, int step, int depth) {
        if (root == null) return;
        if (step + 1 == depth) {
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
            return;
        }
        insert(root.left, val, step + 1, depth);
        insert(root.right, val, step + 1, depth);
    }
}