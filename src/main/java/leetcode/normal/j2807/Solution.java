package leetcode.normal.j2807;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/description/">2807. 在链表中插入最大公约数</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int vv = gcd(cur.val, cur.next.val);
            ListNode next = new ListNode(vv, cur.next);
            cur.next = next;
            cur = cur.next.next;
        }
        return head;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}