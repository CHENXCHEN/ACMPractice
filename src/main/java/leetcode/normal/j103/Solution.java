package leetcode.normal.j103;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/description/">103. 二叉树的锯齿形层序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        for (int i = 1; i < ans.size(); i += 2) {
            reverse(ans.get(i));
        }
        return ans;
    }

    void dfs(TreeNode head, int row) {
        if (head == null) return;
        if (ans.size() == row) {
            ans.add(new ArrayList<>());
        }
        ans.get(row).add(head.val);
        dfs(head.left, row + 1);
        dfs(head.right, row + 1);
    }

    void reverse(List<Integer> arr) {
        for (int i = 0, j = arr.size() - 1; i < j; i++, j--) {
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }
    }
}