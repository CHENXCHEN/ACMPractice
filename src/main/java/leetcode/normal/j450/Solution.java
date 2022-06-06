package leetcode.normal.j450;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 450. 删除二叉搜索树中的节点
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode successor = root.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                root.right = deleteNode(root.right, successor.val);
                successor.right = root.right;
                successor.left = root.left;
                return successor;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.deleteNode(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), null), 3);
    }
}