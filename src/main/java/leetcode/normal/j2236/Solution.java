package leetcode.normal.j2236;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/root-equals-sum-of-children/">2236. 判断根结点是否等于子结点之和</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public boolean checkTree(TreeNode root) {
        return getSum(root) == (root.val << 1);
    }

    int getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }
}