package leetcode.normal.j160;


/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 160. 相交链表
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListNodeLen(headA), lenB = getListNodeLen(headB);
        ListNode rHeadA, rHeadB;
        if (lenA > lenB) {
            rHeadA = subListNode(headA, lenA - lenB);
            rHeadB = headB;
        }
        else {
            rHeadA = headA;
            rHeadB = subListNode(headB, lenB - lenA);
        }
        while (rHeadA != rHeadB) {
            rHeadA = rHeadA.next;
            rHeadB = rHeadB.next;
        }
        return rHeadA;
    }

    public int getListNodeLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len += 1;
            head = head.next;
        }
        return len;
    }

    public ListNode subListNode(ListNode head, int skipLen) {
        while (head != null && skipLen > 0) {
            skipLen -= 1;
            head = head.next;
        }
        return head;
    }
}
