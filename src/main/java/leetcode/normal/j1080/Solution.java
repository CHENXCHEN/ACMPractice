package leetcode.normal.j1080;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/">1080. 根到叶路径上的不足节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        int max = dfs(root, 0);
        if (max < limit) return null;
        return root;
    }

    int dfs(TreeNode root, int cur) {
        cur += root.val;
        if (root.left == null && root.right == null) {
            return cur;
        } else if (root.left == null) {
            int rightSum = dfs(root.right, cur);
            if (rightSum < limit) root.right = null;
            return rightSum;
        } else if (root.right == null) {
            int leftSum = dfs(root.left, cur);
            if (leftSum < limit) root.left = null;
            return leftSum;
        } else {
            int leftSum = dfs(root.left, cur);
            int rightSum = dfs(root.right, cur);
            if (leftSum < limit) root.left = null;
            if (rightSum < limit) root.right = null;
            return Math.max(leftSum, rightSum);
        }
    }
}