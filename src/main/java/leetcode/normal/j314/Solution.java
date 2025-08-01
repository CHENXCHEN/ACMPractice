package leetcode.normal.j314;

import java.util.*;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-vertical-order-traversal/description/">314. 二叉树的垂直遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    static class Node {
        TreeNode treeNode;
        int level;

        public Node(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        ArrayDeque<Node> deque = new ArrayDeque<>();
        deque.add(new Node(root, 0));
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            TreeNode treeNode = node.treeNode;
            int level = node.level;
            map.compute(level, (k, v) -> v == null ? new ArrayList<>() : v).add(treeNode.val);
            if (treeNode.left != null) {
                deque.add(new Node(treeNode.left, level - 1));
            }
            if (treeNode.right != null) {
                deque.add(new Node(treeNode.right, level + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>(map.values());
        return ans;
    }
}