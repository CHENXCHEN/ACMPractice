package leetcode.normal.j2032;

/**
 * Created by CHENXCHEN
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 剑指 Offer 52. 两个链表的第一个公共节点
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListNodeLen(headA), lenB = getListNodeLen(headB);
        ListNode rootA = headA, rootB = headB;
        if (lenA > lenB) {
            rootA = skipNode(headA, lenA - lenB);
        } else {
            rootB = skipNode(headB, lenB - lenA);
        }
        while (rootA != null && rootB != null && rootA != rootB) {
            rootA = rootA.next;
            rootB = rootB.next;
        }
        return rootA == rootB ? rootA : null;
    }

    int getListNodeLen(ListNode root) {
        int len = 0;
        while (root != null) {
            ++len;
            root = root.next;
        }
        return len;
    }

    ListNode skipNode(ListNode root, int len) {
        while (len > 0) {
            root = root.next;
            --len;
        }
        return root;
    }
}