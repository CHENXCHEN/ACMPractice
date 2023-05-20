package leetcode.normal.j1373;

/**
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class ResNode {
        int childSum, minNum, maxNum;
        boolean isChildSearchTree;

        ResNode(int _childSum, int _minNum, int _maxNum, boolean _isChildSearchTree) {
            childSum = _childSum;
            minNum = _minNum;
            maxNum = _maxNum;
            isChildSearchTree = _isChildSearchTree;
        }
    }

    int ans = 0;

    public int maxSumBST(TreeNode root) {
        ans = 0;
        ResNode cur = dfs(root);
        if (cur.isChildSearchTree) ans = Math.max(ans, cur.childSum);
        return ans;
    }

    ResNode dfs(TreeNode root) {
        if (root == null) return new ResNode(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        ResNode left = dfs(root.left);
        ResNode right = dfs(root.right);
        if (left.isChildSearchTree) ans = Math.max(ans, left.childSum);
        if (right.isChildSearchTree) ans = Math.max(ans, right.childSum);
        ResNode res = new ResNode(left.childSum + right.childSum + root.val,
                Math.min(Math.min(left.minNum, right.minNum), root.val),
                Math.max(Math.max(left.maxNum, right.maxNum), root.val),
                left.isChildSearchTree && right.isChildSearchTree &&
                        (root.left == null || root.left.val < root.val) &&
                        (root.right == null || root.val < root.right.val) &&
                        root.val < right.minNum &&
                        left.maxNum < root.val
        );
        return res;
    }
}