package leetcode.normal.j145;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">145. 二叉树的后序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Integer> ans;

    public List<Integer> postorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    void dfs(TreeNode head) {
        if (head == null) return;
        dfs(head.left);
        dfs(head.right);
        ans.add(head.val);
    }
}