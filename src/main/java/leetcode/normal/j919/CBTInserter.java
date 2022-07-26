package leetcode.normal.j919;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/">919. 完全二叉树插入器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/">919. 完全二叉树插入器</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class CBTInserter {
    ArrayDeque<TreeNode> noChild = new ArrayDeque<>();
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode now = deque.pop();
            if (now.left != null) deque.add(now.left);
            if (now.right != null) deque.add(now.right);
            if (now.left == null || now.right == null) noChild.add(now);
        }
    }

    public int insert(int val) {
        TreeNode now = new TreeNode(val);
        TreeNode peek = noChild.peek();
        if (peek.left == null) {
            peek.left = now;
        } else {
            peek.right = now;
            noChild.pop();
        }
        noChild.add(now);
        return peek.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */