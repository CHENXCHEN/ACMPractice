package leetcode.normal.j333;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/largest-bst-subtree/description/">333. 最大二叉搜索子树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int ans = 0;

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        dfs(root);
        return ans;
    }

    // [是否是BST，节点数，最小值，最大值]
    int[] dfs(TreeNode root) {
        int[] left = null;
        int[] right = null;
        int min = root.val, max = root.val;
        if (root.left != null) left = dfs(root.left);
        if (root.right != null) right = dfs(root.right);
        if (left != null) {
            min = Math.min(min, left[2]);
            max = Math.max(max, left[3]);
        }
        if (right != null) {
            min = Math.min(min, right[2]);
            max = Math.max(max, right[3]);
        }
        int[] cur = new int[]{0, 0, min, max};
        cur[1] = 1 + (left == null ? 0 : left[1]) + (right == null ? 0 : right[1]);
        // 判断当前是否为 BST
        // 当前值大于左边的最大值，且当前值小于右边的最小值
        if ((left == null || left[0] == 1) && (right == null || right[0] == 1) && (left == null || left[3] < root.val) && (right == null || root.val < right[2])) {
//            System.out.println("largestBSTSubtree: " + root.val + " leftMax: " + (left == null ? -1: left[2]) + " rightMin: " + (right == null ? -1 : right[2]));
            cur[0] = 1;
            ans = Math.max(ans, cur[1]);
        }
        return cur;
    }
}