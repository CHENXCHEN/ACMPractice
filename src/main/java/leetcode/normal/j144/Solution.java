package leetcode.normal.j144;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description/">144. 二叉树的前序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Integer> ans;

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    void dfs(TreeNode head) {
        if (head == null) return;
        ans.add(head.val);
        dfs(head.left);
        dfs(head.right);
    }
}