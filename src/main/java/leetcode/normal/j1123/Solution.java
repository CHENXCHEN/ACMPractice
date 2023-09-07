package leetcode.normal.j1123;

import javafx.util.Pair;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/">1123. 最深叶节点的最近公共祖先</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (root == null) return new Pair<>(null, 0);
        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);
        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        } else if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        } else return new Pair<>(root, left.getValue() + 1);
    }
}