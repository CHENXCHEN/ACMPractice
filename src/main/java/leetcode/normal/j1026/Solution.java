package leetcode.normal.j1026;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/">1026. 节点与其祖先之间的最大差值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans;

    public int maxAncestorDiff(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode root) {
        int[] cur = {root.val, root.val};
        if (root.left != null) {
            int[] minMax = dfs(root.left);
            ans = Math.max(ans, Math.abs(root.val - minMax[0]));
            ans = Math.max(ans, Math.abs(root.val - minMax[1]));
            cur[0] = Math.min(cur[0], minMax[0]);
            cur[1] = Math.max(cur[1], minMax[1]);
        }
        if (root.right != null) {
            int[] minMax = dfs(root.right);
            ans = Math.max(ans, Math.abs(root.val - minMax[0]));
            ans = Math.max(ans, Math.abs(root.val - minMax[1]));
            cur[0] = Math.min(cur[0], minMax[0]);
            cur[1] = Math.max(cur[1], minMax[1]);
        }
        return cur;
    }
}