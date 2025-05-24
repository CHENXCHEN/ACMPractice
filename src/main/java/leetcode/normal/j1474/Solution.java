package leetcode.normal.j1474;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/description/">1474. 删除链表 M 个节点之后的 N 个节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode cur = head;
        while(cur != null) {
            ListNode keepNode = skipNodes(cur, m - 1);
            if (keepNode != null) {
                ListNode skipNode = skipNodes(keepNode.next, n);
                keepNode.next = skipNode;
                cur = skipNode;
            } else {
                break;
            }
        }
        return head;
    }

    ListNode skipNodes(ListNode head, int skipNum) {
        int cnt = 0;
        while (head != null && cnt < skipNum) {
            ++cnt;
            head = head.next;
        }
        return head;
    }
}