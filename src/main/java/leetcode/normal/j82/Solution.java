package leetcode.normal.j82;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/description/">82. 删除排序链表中的重复元素 II</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode root = new ListNode(-1, null);
        ListNode pre = root, cur = head;
        while (cur != null) {
            boolean check = false;
            while (cur.next != null && cur.val == cur.next.val) {
                check = true;
                cur.next = cur.next.next;
            }
            System.out.println("cur: " + cur.val + " check: " + check);
            if (!check) {
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        pre.next = null;
        return root.next;
    }
}
