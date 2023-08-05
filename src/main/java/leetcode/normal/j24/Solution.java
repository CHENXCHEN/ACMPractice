package leetcode.normal.j24;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">24. 两两交换链表中的节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode root = new ListNode(0, head), cur = root;
        while (cur.next != null && cur.next.next != null) {
            ListNode next3 = cur.next.next.next;
            ListNode next2 = cur.next.next;
            ListNode next1 = cur.next;
            cur.next = next2;
            next2.next = next1;
            next1.next = next3;
            cur = next1;
        }
        return root.next;
    }
}