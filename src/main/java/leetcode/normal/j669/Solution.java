package leetcode.normal.j669;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/trim-a-binary-search-tree/">669. 修剪二叉搜索树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }

    TreeNode dfs(TreeNode root, int low, int high) {
        root = getTrimValidNode(root, low, high);
        if (root != null) {
            root.left = getTrimValidNode(root.left, low, high);
            root.right = getTrimValidNode(root.right, low, high);
            dfs(root.left, low, high);
            dfs(root.right, low, high);
        }
        return root;
    }

    TreeNode getTrimValidNode(TreeNode root, int low, int high) {
        while (root != null && !(low <= root.val && root.val <= high)) {
            if (root.val < low) root = root.right;
            else root = root.left;
        }
        return root;
    }
}