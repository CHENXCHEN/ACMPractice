package leetcode.normal.j235;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. 二叉搜索树的最近公共祖先</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        solve(root, p, q);
        return ans;
    }

    int solve(TreeNode root, TreeNode p, TreeNode q) {
        int res = 0;
        if (root == null) return res;
        if (root == p || root == q) res += 1;
        res += solve(root.left, p, q);
        res += solve(root.right, p, q);
        if (res == 2 && ans == null) {
            ans = root;
        }
        return res;
    }
}