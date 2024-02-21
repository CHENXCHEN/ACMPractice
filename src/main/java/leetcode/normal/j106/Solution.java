package leetcode.normal.j106;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106. 从中序与后序遍历序列构造二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeMap<Integer, Integer> idxMap;
    int n;
    int[] inorder, postorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        idxMap = new TreeMap<>();
        n = inorder.length;
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }
        return solve(0, n - 1, 0, n - 1);
    }

    TreeNode solve(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) return null;
        int root = postorder[postEnd];
        TreeNode cur = new TreeNode(root);
        int inRootPos = idxMap.get(root);
        int leftSize = inRootPos - inStart;
        cur.left = solve(inStart, inRootPos - 1, postStart, postStart + leftSize - 1);
        cur.right = solve(inRootPos + 1, inEnd, postStart + leftSize, postEnd - 1);
        return cur;
    }
}