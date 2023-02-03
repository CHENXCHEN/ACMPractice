package leetcode.normal.j1145;

import java.util.Arrays;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-coloring-game/">1145. 二叉树着色游戏</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] childCount = new int[3];
    int x;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        countTree(root);
        childCount[2] = n - 1 - childCount[0] - childCount[1];
        Arrays.sort(childCount);
        return childCount[2] > childCount[1] + childCount[0];
    }

    int countTree(TreeNode root) {
        int cnt = root == null ? 0 : 1;
        if (root != null) {
            int leftCnt = countTree(root.left);
            cnt += leftCnt;
            int rightCht = countTree(root.right);
            cnt += rightCht;
            if (root.val == x) {
                childCount[0] = leftCnt;
                childCount[1] = rightCht;
            }
        }
        return cnt;
    }
}