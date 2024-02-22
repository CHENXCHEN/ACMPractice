package leetcode.normal.j889;

import java.util.TreeMap;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/">889. 根据前序和后序遍历构造二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    TreeMap<Integer, Integer> idxMap;
    int n;
    int[] preOrder, postOrder;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        idxMap = new TreeMap<>();
        preOrder = preorder;
        postOrder = postorder;
        n = preOrder.length;
        for (int i = 0; i < n; i++) {
            idxMap.put(postorder[i], i);
        }
        return solve(0, n - 1, 0, n - 1);
    }

    TreeNode solve(int preStart, int preEnd, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        TreeNode treeNode = new TreeNode(preOrder[preStart]);
        if (preStart == preEnd) return treeNode;
        int leftSize = idxMap.get(preOrder[preStart + 1]) - postStart + 1;
        treeNode.left = solve(preStart + 1, preStart + leftSize, postStart, postStart + leftSize - 1);
        treeNode.right = solve(preStart + leftSize + 1, preEnd, postStart + leftSize, postEnd - 1);
        return treeNode;
    }
}