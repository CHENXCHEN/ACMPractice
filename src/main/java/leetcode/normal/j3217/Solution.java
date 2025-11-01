package leetcode.normal.j3217;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by CHENXCHEN
 * <a href="https://leetcode.cn/problems/delete-nodes-from-linked-list-present-in-array/description/">3217. 从链表中移除在数组中存在的节点</a>
 *
 * @author <a href="mailto:chenhuachaoxyz@gmail.com">报时</a>
 */
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> ss = new HashSet<>();
        for (int num : nums) {
            ss.add(num);
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root, cur = head;
        while (cur != null) {
            if (ss.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return root.next;
    }
}