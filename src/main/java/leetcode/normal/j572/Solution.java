package leetcode.normal.j572;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/subtree-of-another-tree/description/">572. 另一棵树的子树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        int maxHeight = dfs(subRoot, 0, null);
        ArrayList<TreeNode> list = new ArrayList<>();
        dfs(root, maxHeight, list);
        for (TreeNode treeNode : list) {
            if (isSameTree(subRoot, treeNode)) return true;
        }
        return false;
    }

    int dfs(TreeNode root, int targetHeight, ArrayList<TreeNode> nodes) {
        if (root == null) return 0;
        int height = Math.max(dfs(root.left, targetHeight, nodes), dfs(root.right, targetHeight, nodes)) + 1;
        if (nodes != null && height == targetHeight) {
            nodes.add(root);
        }
        return height;
    }

    boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return root1.val == root2.val &&
                isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}