package leetcode.normal.j429;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/">429. N 叉树的层序遍历</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(Node root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    void dfs(Node head, int row) {
        if (head == null) return;
        if (ans.size() == row) {
            ans.add(new ArrayList<>());
        }
        ans.get(row).add(head.val);
        for (Node child : head.children) {
            dfs(child, row + 1);
        }
    }
}