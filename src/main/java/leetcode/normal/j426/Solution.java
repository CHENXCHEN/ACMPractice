package leetcode.normal.j426;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/">426. 将二叉搜索树转化为排序的双向链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */

class Solution {
    Node head, tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        head = new Node(0);
        tail = head;
        dfs(root);
        head = head.right;;
        tail.right = head;
        head.left = tail;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        tail.right = new Node(cur.val);
        tail.right.left = tail;
        tail = tail.right;
        dfs(cur.right);
    }
}