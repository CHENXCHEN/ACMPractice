package leetcode.normal.j105;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">105. 从前序与中序遍历序列构造二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] preorder, inorder;
    int n;
    TreeMap<Integer, Integer> idxInOrder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        idxInOrder = new TreeMap<>();
        n = inorder.length;
        for (int i = 0; i < n; i++) {
            idxInOrder.put(inorder[i], i);
        }
        return solve(0, n - 1, 0, n - 1);
    }

    TreeNode solve(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) return null;
        int inOrderRoot = idxInOrder.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        // 计算左子树的节点数
        int leftSize = inOrderRoot - inStart;
//        System.out.println("preStart: " + preStart + " preEnd: " + preEnd + " inStart: " + inStart + " inEnd: " + inEnd + " leftSize: " + leftSize);
        root.left = solve(preStart + 1, preStart + leftSize, inStart, inOrderRoot - 1);
        root.right = solve(preStart + leftSize + 1, preEnd, inOrderRoot + 1, inEnd);
        return root;
    }
}