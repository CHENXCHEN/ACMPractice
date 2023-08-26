package leetcode.normal.j1448;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/count-good-nodes-in-binary-tree/">1448. 统计二叉树中好节点的数目</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    int dfs(TreeNode root, int max) {
        if (root == null) return 0;
        int cur = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        cur += dfs(root.left, max);
        cur += dfs(root.right, max);
        return cur;
    }
}