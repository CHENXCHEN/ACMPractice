package leetcode.normal.j107;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/description/">107. 二叉树的层序遍历 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        for (int i = 0, j = ans.size() - 1; i < j; i++, j--) {
            List<Integer> tmp = ans.get(i);
            ans.set(i, ans.get(j));
            ans.set(j, tmp);
        }
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