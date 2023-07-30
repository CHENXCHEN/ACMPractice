package leetcode.normal.j141;

import java.util.HashSet;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/linked-list-cycle/">141. 环形链表</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> vis = new HashSet<>();
        while (head != null) {
            vis.add(head);
            head = head.next;
            if (vis.contains(head)) return true;
        }
        return false;
    }
}