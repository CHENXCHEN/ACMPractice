package leetcode.normal.j117;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/description/">117. 填充每个节点的下一个右侧节点指针 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    ArrayList<Node> res;

    public Node connect(Node root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return root;
    }

    void dfs(Node root, int level) {
        if (root == null) return;
        if (level < res.size()) {
            res.get(level).next = root;
        }
        if (res.size() == level) res.add(root);
        else res.set(level, root);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}