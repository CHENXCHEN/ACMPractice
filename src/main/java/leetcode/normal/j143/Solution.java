package leetcode.normal.j143;

import java.util.ArrayList;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/reorder-list/">143. 重排链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public void reorderList(ListNode head) {
        ArrayList<ListNode> lst = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            lst.add(cur);
            cur = cur.next;
        }
        int n = lst.size(), leftPos = 1, rightPos = n - 1;
        cur = head;
        for (int i = 1; i < n && leftPos <= rightPos; i++) {
            ListNode now;
            if ((i & 1) == 1) {
                now = lst.get(rightPos--);
            } else {
                now = lst.get(leftPos++);
            }
            now.next = null;
            cur.next = now;
            cur = now;
        }
    }
}
