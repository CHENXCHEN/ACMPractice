package leetcode.normal.j25;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/">25. K 个一组翻转链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0, head);
        ListNode firstPre = root, last;
        while (true) {
            ListNode first = firstPre.next;
            last = first;
            for (int i = 0; i < k - 1 && last != null; i++) {
                last = last.next;
            }
            // 如果不足 k 个，则停止
            if (last == null) break;
            System.out.println("1: first: " + first.val + " last: " + last.val);
            ListNode groupNext = last.next;
            last.next = null;
            // 反转链表，转完之后，前后逆转
            reverseNode(first, last);
            System.out.println("2: first: " + first.val + " last: " + last.val);
            System.out.println("3: first.next: " + first.next.val + " last.next: " + last.next.val);
            firstPre.next = last;
            first.next = groupNext;
            firstPre = first;
        }
        return root.next;
    }

    ListNode reverseNode(ListNode first, ListNode last) {
        ListNode pre = null;
        ListNode cur = first;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return cur;
    }
}