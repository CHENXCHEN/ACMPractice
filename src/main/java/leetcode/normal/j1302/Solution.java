package leetcode.normal.j1302;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/deepest-leaves-sum/">1302. 层数最深叶子节点的和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int maxLevel = 0;
    int levelAns = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return levelAns;
    }

    void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxLevel) {
            maxLevel = level;
            levelAns = 0;
        }
        if (level == maxLevel) {
            levelAns += root.val;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}