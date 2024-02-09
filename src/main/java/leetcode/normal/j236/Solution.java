package leetcode.normal.j236;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">236. 二叉树的最近公共祖先</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeNode ans, p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        this.p = p;
        this.q = q;
        dfs(root);
        return ans;
    }

    boolean dfs(TreeNode head) {
        if (ans != null) return true;
        if (head == null) return false;
        boolean isCur = head == p || head == q;
        boolean left = dfs(head.left);
        boolean right = dfs(head.right);
        if (ans == null && ((left && right) || (isCur && (left || right)))) {
            ans = head;
        }
        return left || right || isCur;
    }
}