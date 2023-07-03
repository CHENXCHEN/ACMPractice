package leetcode.normal.j445;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/add-two-numbers-ii/">445. 两数相加 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return reverse(add(reverse(l1), reverse(l2)));
    }

    ListNode reverse(ListNode listNode) {
        return reverse(listNode, listNode.next);
    }

    ListNode reverse(ListNode parent, ListNode current) {
        if (current == null) return parent;
        if (parent.next == current) parent.next = null;
        ListNode next = current.next;
        current.next = parent;
        return reverse(current, next);
    }

    ListNode add(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode root = new ListNode(0), cur = root;
        while (l1 != null || l2 != null || pre > 0) {
            int ss = pre;
            if (l1 != null) {
                ss += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                ss += l2.val;
                l2 = l2.next;
            }
            pre = ss / 10;
            cur.next = new ListNode(ss % 10);
            cur = cur.next;
        }
        return root.next;
    }
}