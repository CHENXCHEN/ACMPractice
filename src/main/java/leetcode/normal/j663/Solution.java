package leetcode.normal.j663;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/equal-tree-partition/description/">663. 均匀树划分</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    long total = 0L;
    boolean check = false;

    public boolean checkEqualTree(TreeNode root) {
        total = dfs1(root);
        dfs2(root, null);
        return check;
    }

    long dfs1(TreeNode root) {
        if (root == null) return 0L;
        return root.val + dfs1(root.left) + dfs1(root.right);
    }

    long dfs2(TreeNode root, TreeNode parent) {
        if (root == null) return 0L;
        long cur = root.val + dfs2(root.left, root) + dfs2(root.right, root);
        if (parent != null && cur * 2 == total) check = true;
        return cur;
    }
}