package leetcode.normal.j2;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/add-two-numbers/">2. 两数相加</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(), cur = root;
        int pre = 0;
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
            cur.next = new ListNode(ss % 10);
            pre = ss / 10;
            cur = cur.next;
        }
        return root.next;
    }
}