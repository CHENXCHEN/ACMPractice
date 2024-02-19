package leetcode.normal.j590;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/">590. N 叉树的后序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<Integer> ans;

    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    void dfs(Node head) {
        if (head == null) return;
        for (Node child : head.children) {
            dfs(child);
        }
        ans.add(head.val);
    }
}