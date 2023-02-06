package leetcode.normal.j2331;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/evaluate-boolean-binary-tree/">2331. 计算布尔二叉树的值</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) return root.val == 1;
        return root.val == 2 ? evaluateTree(root.left) | evaluateTree(root.right) : evaluateTree(root.left) & evaluateTree(root.right);
    }
}