package leetcode.normal.j203;


/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 203. 移除链表元素
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1, head);
        ListNode cur = root;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return root.next;
    }
}