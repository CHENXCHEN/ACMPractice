package leetcode.normal.j998;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/">998. 最大二叉树 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root.val < val) {
            return new TreeNode(val, root, null);
        }
        transform(root, root.right, val);
        return root;
    }

    void transform(TreeNode parent, TreeNode now, int val) {
        if (now == null || val > now.val) {
            parent.right = new TreeNode(val, now, null);
        } else {
            transform(now, now.right, val);
        }
    }
}