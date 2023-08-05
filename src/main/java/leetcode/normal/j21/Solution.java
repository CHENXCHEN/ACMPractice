package leetcode.normal.j21;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">21. 合并两个有序链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(), cur = root;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                int minVal = Math.min(list1.val, list2.val);
                if (list1.val < list2.val) {
                    list1 = list1.next;
                } else {
                    list2 = list2.next;
                }
                cur.next = new ListNode(minVal);
            } else if (list1 != null) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return root.next;
    }
}