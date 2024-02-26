package leetcode.normal.j938;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/range-sum-of-bst/description/">938. 二叉搜索树的范围和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if (root == null) return ans;
        if (low <= root.val && root.val <= high) ans += root.val;
        if (root.val >= low) ans += rangeSumBST(root.left, low, high);
        if (root.val <= high) ans += rangeSumBST(root.right, low, high);
        return ans;
    }
}