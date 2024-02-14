package leetcode.normal.j102;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/">102. 二叉树的层序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode head, int row) {
        if (head == null) return;
        if (row == ans.size()) ans.add(new ArrayList<>());
        ans.get(row).add(head.val);
        dfs(head.left, row + 1);
        dfs(head.right, row + 1);
    }
}