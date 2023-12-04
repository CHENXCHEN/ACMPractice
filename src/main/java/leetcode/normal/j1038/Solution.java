package leetcode.normal.j1038;

/**
 * <a href="https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/description/">1038. 从二叉搜索树到更大和树</a>
 * Created by CHENXCHEN
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            root.val = sum += root.val;
            bstToGst(root.left);
        }
        return root;
    }

}