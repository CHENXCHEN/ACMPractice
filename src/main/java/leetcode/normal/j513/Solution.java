package leetcode.normal.j513;

/**
 * Created by CHENXCHEN
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * 513. 找树左下角的值
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int maxDepth = -1;
    int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            ans = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}