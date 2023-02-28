package leetcode.normal.j206;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reverse-linked-list/">206. 反转链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode lastParent = null, parent = head, cur = parent.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = parent;
            parent.next = lastParent;
            lastParent = parent;
            parent = cur;
            cur = next;
        }
        return parent;
    }
}