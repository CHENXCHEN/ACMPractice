package leetcode.normal.j449;

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 */
public class Codec {

    ArrayList<Integer> serArr;

    void sTreeNode(TreeNode root) {
        if (root == null) {
            serArr.add(null);
            return;
        }
        serArr.add(root.val);
        sTreeNode(root.left);
        sTreeNode(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serArr = new ArrayList<>();
        sTreeNode(root);
        String ansStr = serArr.toString();
        return ansStr.substring(1, ansStr.length() - 1);
    }

    int step;

    TreeNode reTreeNode() {
        step++;
        if (step >= desArr.length || desArr[step] == null) return null;
        TreeNode treeNode = new TreeNode(desArr[step]);
        treeNode.left = reTreeNode();
        treeNode.right = reTreeNode();
        return treeNode;
    }

    Integer[] desArr;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.trim().length() == 0) return null;
        String[] strs = data.split(",");
        desArr = new Integer[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String trim = strs[i].trim();
            if (trim.equals("null")) desArr[i] = null;
            else desArr[i] = Integer.parseInt(trim);
        }
        step = -1;
        return reTreeNode();
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
