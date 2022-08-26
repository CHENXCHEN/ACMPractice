package leetcode.normal.j662;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-width-of-binary-tree/">662. 二叉树最大宽度</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        long[][] minMaxNum = new long[3001][2];
        dfs(root, 1, 1, minMaxNum);
        long ans = 0;
        for (int i = 1; i < minMaxNum.length; i++) {
            ans = Math.max(ans, minMaxNum[i][1] - minMaxNum[i][0] + 1);
        }
        return (int) ans;
    }

    void dfs(TreeNode root, long number, int level, long[][] minMaxNum) {
        if (root == null) return;
        if (minMaxNum[level][0] == 0) minMaxNum[level][0] = minMaxNum[level][1] = number;
        minMaxNum[level][0] = Math.min(minMaxNum[level][0], number);
        minMaxNum[level][1] = Math.max(minMaxNum[level][1], number);
        dfs(root.left, number << 1, level + 1, minMaxNum);
        dfs(root.right, (number << 1) | 1, level + 1, minMaxNum);
    }
}