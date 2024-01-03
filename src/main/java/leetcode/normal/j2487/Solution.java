package leetcode.normal.j2487;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-nodes-from-linked-list/description/">2487. 从链表中移除节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) return head;
        dfs(head.next, head);
        if (head.val < head.next.val) return head.next;
        return head;
    }

    int dfs(ListNode cur, ListNode parent) {
        int res = Integer.MIN_VALUE;
        if (cur == null) return res;
        res = dfs(cur.next, cur);
        if (cur.val < res) {
            parent.next = cur.next;
        } else res = cur.val;
        return res;
    }
}