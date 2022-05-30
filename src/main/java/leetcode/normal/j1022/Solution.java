package leetcode.normal.j1022;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 * 1022. 从根到叶的二进制数之和
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        dfsSum(root, 0);
        return ans;
    }

    public void dfsSum(TreeNode root, int cur) {
        if (root == null) return;
        cur = cur << 1 | root.val;
        if (root.left == null && root.right == null) ans += cur;
        dfsSum(root.left, cur);
        dfsSum(root.right, cur);
    }
}