package leetcode.normal.j2181;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/merge-nodes-in-between-zeros/description/">2181. 合并零之间的节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode root = new ListNode(), tail = root;
        while (head != null) {
            while (head != null && head.val == 0) head = head.next;
            int cur = 0;
            while (head != null && head.val != 0) {
                cur += head.val;
                head = head.next;
            }
            if (cur > 0) {
                tail.next = new ListNode(cur);
                tail = tail.next;
            }
        }
        return root.next;
    }
}