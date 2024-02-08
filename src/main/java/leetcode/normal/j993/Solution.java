package leetcode.normal.j993;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/cousins-in-binary-tree/description/">993. 二叉树的堂兄弟节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] level;
    int[] parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        level = new int[101];
        parent = new int[101];
        parent[root.val] = root.val;
        dfs(root, 0);
        return level[x] == level[y] && parent[x] != parent[y];
    }

    void dfs(TreeNode root, int step) {
        if (root == null) return;
        level[root.val] = step;
        if (root.left != null) {
            parent[root.left.val] = root.val;
            dfs(root.left, step + 1);
        }
        if (root.right != null) {
            parent[root.right.val] = root.val;
            dfs(root.right, step + 1);
        }
    }
}