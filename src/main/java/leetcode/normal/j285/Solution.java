package leetcode.normal.j285;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/inorder-successor-in-bst/description/">285. 二叉搜索树中的中序后继</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = p;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        TreeNode ans = null;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node.val > p.val) {
                if (ans == null || ans.val > node.val) {
                    ans = node;
                }
            }
            if (node.left != null)
                deque.add(node.left);
            if (node.right != null)
                deque.add(node.right);
        }
        return ans;
    }
}