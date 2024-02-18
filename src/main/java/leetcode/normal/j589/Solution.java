package leetcode.normal.j589;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/">589. N 叉树的前序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<Integer> ans;

    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    void dfs(Node head) {
        if (head == null) return;
        ans.add(head.val);
        for (Node child : head.children) {
            dfs(child);
        }
    }
}