package leetcode.normal.j654;

import java.util.ArrayDeque;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/">654. 最大二叉树</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        TreeNode[] tree = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tree[i] = new TreeNode(nums[i]);
            while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                tree[i].left = tree[deque.pop()];
            }
            if (!deque.isEmpty()) {
                tree[deque.peek()].right = tree[i];
            }
            deque.push(i);
        }
        return tree[deque.getLast()];
    }
}