package leetcode.normal.j1367;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/linked-list-in-binary-tree/description/">1367. 二叉树中的链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    int[] next;
    ArrayList<Integer> list;

    public boolean isSubPath(ListNode head, TreeNode root) {
        list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        next = getNext(list);
        return dfs(root, 0);
    }

    boolean dfs(TreeNode root, int j) {
        if (j >= list.size()) return true;
        if (root == null) return false;
        while (j > 0 && root.val != list.get(j)) {
            j = next[j - 1];
        }
        if (root.val == list.get(j)) ++j;
        return dfs(root.left, j) || dfs(root.right, j);
    }

    int[] getNext(ArrayList<Integer> list) {
        int[] next = new int[list.size()];
        for (int i = 1, j = 0; i < list.size(); i++) {
            while (j > 0 && list.get(i) != list.get(j)) j = next[j - 1];
            if (list.get(i).equals(list.get(j))) ++j;
            next[i] = j;
        }
        return next;
    }
}