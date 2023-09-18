package leetcode.normal.j337;

import javafx.util.Pair;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/house-robber-iii/description/">337. 打家劫舍 III</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int rob(TreeNode root) {
        Pair<Integer, Integer> ans = dfs(root);
        return Math.max(ans.getKey(), ans.getValue());
    }

    Pair<Integer, Integer> dfs(TreeNode root) {
        if (root == null) return new Pair<>(0, 0);
        Pair<Integer, Integer> left = dfs(root.left), right = dfs(root.right);
        int takeCurrent = root.val + left.getValue() + right.getValue();
        int noTakeCurrent = left.getKey() + right.getKey();
        return new Pair<>(Math.max(takeCurrent, noTakeCurrent), noTakeCurrent);
    }
}